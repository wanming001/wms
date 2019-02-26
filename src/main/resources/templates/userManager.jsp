<%--
  Created by IntelliJ IDEA.
  User: WanMing
  Date: 2019/1/28
  Time: 10:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>表单元素</title>
    <link rel="stylesheet" href="../static/resources/layui/css/layui.css">
    <script type="text/javascript" src="../static/resources/layui/layui.js"></script>
</head>

<body>

<%--查询开始--%>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>查询条件</legend>
</fieldset>
<form class="layui-form"  id="searchFrm">
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">用户名:</label>
            <div class="layui-input-inline">
                <input type="text" name="username"  autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">性别:</label>
            <div class="layui-input-inline">
                <input type="text" name="sex"  autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">用户地址:</label>
            <div class="layui-input-inline">
                <input type="text" name="city"  autocomplete="off" class="layui-input">
            </div>
        </div>
    </div>
    <div class="layui-form-item" style="text-align: center;">
        <div class="layui-input-block">
            <button type="button" class="layui-btn" id="doSearch">查询</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>
<%--查询结束--%>


<%--设置加载数据的容器开始--%>
<table class="layui-hide" id="test" lay-filter="test"></table>

<%--头部的工具栏--%>
<script type="text/html" id="toolbarDemo">
    <div class="layui-btn-container">
        <button class="layui-btn layui-btn-warm layui-btn-sm" lay-event="add">添加</button>
        <button type="button" class="layui-btn  layui-btn-sm layui-btn-danger" lay-event="batchDelete">批量删除</button>
    </div>
</script>

<%--行内工具--%>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="view">查看</a>
    <a class="layui-btn layui-btn-xs" lay-event="update">修改</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="delete">删除</a>
</script>

<%--设置加载数据的容器结束--%>

<!-- 添加修改开始 -->
<div id="addAndUpdateUser" style="display: none;">
    <form class="layui-form"  id="dataFrm" lay-filter="dataFrm" style="margin: 10px">
        <div class="layui-form-item">
            <label class="layui-form-label">用户名</label>
            <div class="layui-input-block">
                <input type="text" name="username"  autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">用户城市</label>
            <div class="layui-input-block">
                <input type="text" name="city"  autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">用户签名</label>
            <div class="layui-input-block">
                <textarea type="text" name="sign"  autocomplete="off" id="sign" class="layui-input"></textarea>
            </div>
        </div>
        <div class="layui-form-item" style="text-align: center;">
            <div class="layui-input-block">
                <button type="button" class="layui-btn" lay-submit="" lay-filter="doSubmit">保存</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
</div>
<!-- 添加修改结束-->


<script>
    layui.use(['element','form','table','jquery','layer','layedit'],function () {
        var element = layui.element;
        var form = layui.form;
        var table = layui.table;
        var $ = layui.jquery;
        var layer = layui.layer;
        var layedit = layui.layedit;
        layedit.build("sign");

        //加载数据表格
   var tableinit = table.render({
            elem: '#test'
            ,url:'resources/json/user.json'
            ,cellMinWidth: 80 //全局定义常规单元格的最小宽度
            ,height:'full-200'
            ,title:'用户列表'
            ,text:'<font>查无数据</font>'
            ,defaultToolbar:['print','filter']
            ,cols: [ [

                {type:'numbers',title:'序号',width:100}
                ,{field:'id', width:80,align:'center', title: 'ID', sort: true}
                ,{field:'username',align:'center',  title: '用户名'}
                ,{field:'sex',align:'center', title: '性别', sort: true}
                ,{field:'city',align:'center',  title: '城市'}
                ,{field:'sign',align:'center', title: '签名'} //minWidth：局部定义当前单元格的最小宽度，layui 2.2.1 新增
                ,{field:'experience',align:'center',title: '积分', sort: true}
                ,{field:'score',align:'center', title: '评分', sort: true,templet:function (d) {
                        return d.score>60?'<font color="green">及格</font>':'<font color="red">不及格</font>';
                    }}
                ,{field:'classify',align:'center', title: '职业'}
                ,{field:'wealth',align:'center', title: '财富', sort: true}
                ,{fixed: 'right',align:'center', title:'操作', toolbar: '#barDemo', width:200}
            ] ]
            ,page:true
            ,toolbar: '#toolbarDemo'
            ,limit:5
            ,limits:[5,10,15]
        });

       //查询
        $("#doSearch").click(function () {
            var param = $("#searchFrm").serialize();
            tableinit.reload({url:'resources/json/user.json?'+param});
        });

        //监听表头工具栏事件
        table.on('toolbar(test)',function (obj) {
            console.log("1111");
            switch (obj.event) {
                case 'add':
                    layer.msg("添加");
                    toAddUser();
                    break;
                case 'batchDelete':
                    layer.msg("批量删除");
                    var checkStatus = table.checkStatus('test');//test就是<table id="test">
                    layer.msg(JSON.stringify(checkStatus.data));
                    break;
            }
        });

        //监听行内工具栏事件
        table.on('tool(test)',function (obj) {
            var data = obj.data; //获得当前行数据
            switch(obj.event){
                case 'update':
                    toUpdateUser(data);
                    break;
                case 'delete':
                    //ajax异步删除

                    //刷新表单
                    tableinit.reload();

                    layer.msg('删除'+data.id);
                    break;
                case 'view':
                    //toView(data);
                    layer.msg('查看'+data.id);
                    break;
            }
        });

        var url;//提交的url
        var index;//要关闭的弹出层索引

        //添加用户
        function toAddUser() {
            url = 'user/addUser.action';
            index = layer.open({
                type:1,
                title:'添加用户',
                content:$("#addAndUpdateUser"),  //type=1时使用
                skin:'layui-layer-molv',//设置皮肤
                area: ['500px', '300px'],//设置宽高
                shade:0.5,//设置遮罩的透明度
                shadeClose:true,//设置点击遮罩是否关闭弹出层
                maxmin:true, //是否显示最大化和最小化的按钮  该参数值对type:1和type:2有效
                success:function(){
                    $("#dataFrm")[0].reset();
                }
            });
        }

        //修改用户
        function toUpdateUser(data) {
            url = 'user/updateUser.action';
            index = layer.open({
                type:1,
                title:'修改用户',
                content:$("#addAndUpdateUser"),  //type=1时使用
                skin:'layui-layer-molv',//设置皮肤
                area: ['500px', '300px'],//设置宽高
                shade:0.5,//设置遮罩的透明度
                shadeClose:true,//设置点击遮罩是否关闭弹出层
                maxmin:true, //是否显示最大化和最小化的按钮  该参数值对type:1和type:2有效
                success:function(){
                    form.val('dataFrm',data);

                    layedit.setContent(1,data.sign);

                    form.render();
                }
            });
        }

        //查看

        //保存
        form.on('submit(doSubmit)',function (obj) {
            $.post(url,function(result){
                if(result.code>0){
                    layer.msg(result.msg);
                }
                tableinit.reload();
                layer.close(index);
            });

            return false;//阻止同步提交
        });



    });



</script>
</body>
</html>
