package com.sxt.sys.utils;

import com.sxt.sys.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @author WanMing
 * @date 2019/1/27 20:59
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ActiverUser {

    private User user;
    private List<String> roles;
    private List<String> permissions;

    }
