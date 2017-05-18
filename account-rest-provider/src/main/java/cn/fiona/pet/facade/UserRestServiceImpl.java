package cn.fiona.pet.facade;

import cn.fiona.pet.converter.DefaultDataConverter;
import cn.fiona.pet.dto.UserDTO;
import cn.fiona.pet.entity.User;
import cn.fiona.pet.service.UserService;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;

import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.swagger.annotations.Api;
import lombok.Getter;

/**
 * 用户信息
 * Created by tom on 2017-03-07 13:25:01.
 */
@Service(protocol = "rest")
@Path("users")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({ContentType.APPLICATION_JSON_UTF_8})
@Api(value = "users", description = "用户信息接口")
@Getter
public class UserRestServiceImpl extends ConverterRestServiceBase<UserDTO, User> implements UserRestService {
    @Autowired
    private UserService service;

    @Override
    public void forwardAfter(final UserDTO userDTO) {
        userDTO.setEnterpriseId("锐捷网络");
    }
}