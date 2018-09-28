package com.gs;

import com.alibaba.fastjson.JSON;
import com.gs.subproject.user.ao.GetUserAO;
import io.protostuff.LinkedBuffer;
import io.protostuff.ProtobufIOUtil;
import io.protostuff.runtime.RuntimeSchema;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    RedisTemplate redisTemplate;

    static RuntimeSchema<GetUserAO> getUserAORuntimeSchema = RuntimeSchema.createFrom(GetUserAO.class);

    @Test
    public void testSetRedis() {
        redisTemplate.opsForValue().set("aaa", "bbb");
    }

    @Test
    public void testGetRedis() {
        System.out.println(redisTemplate.opsForValue().get("aaa"));
    }

    @Test
    public void testSetObj() {
        GetUserAO ao = new GetUserAO();
        ao.setUserId(1);

        byte[] bytes = ProtobufIOUtil.toByteArray
                (ao, getUserAORuntimeSchema, LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));

        redisTemplate.opsForValue().set("ccc", bytes);
    }

    @Test
    public void testGetObj() {
        byte[] bytes = (byte[]) redisTemplate.opsForValue().get("ccc");
        GetUserAO getUserAO = getUserAORuntimeSchema.newMessage();
        ProtobufIOUtil.mergeFrom(bytes, getUserAO, getUserAORuntimeSchema);
        System.out.println(JSON.toJSONString(getUserAO));
    }

}
