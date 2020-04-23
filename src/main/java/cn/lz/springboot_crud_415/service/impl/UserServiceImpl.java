package cn.lz.springboot_crud_415.service.impl;

import cn.lz.springboot_crud_415.mapper.UserMapper;
import cn.lz.springboot_crud_415.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;

    @Override
    public List<Map> findAll() {
        return userMapper.findAll();
    }
}
