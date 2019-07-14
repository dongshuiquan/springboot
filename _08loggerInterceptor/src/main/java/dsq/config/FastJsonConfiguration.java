package dsq.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aa on 2019/7/13.
 */
@Configuration
public class FastJsonConfiguration implements WebMvcConfigurer {

    /**
     * 配置消息转换器
     * @param converters
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {


        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
        //自定义配置...
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        //3.设置成了PrettyFormat格式
        fastJsonConfig.setSerializerFeatures(
                SerializerFeature.PrettyFormat,
                SerializerFeature.WriteMapNullValue,//是否输出值为null的字段,默认为false
                SerializerFeature.WriteNullBooleanAsFalse,//Boolean字段如果为null,输出为false,而非null
                SerializerFeature.WriteNullListAsEmpty,//List字段如果为null,输出为[],而非nul
                SerializerFeature.DisableCircularReferenceDetect,//消除对同一对象循环引用的问题，默认为false
                SerializerFeature.WriteNullStringAsEmpty//字符类型字段如果为null,输出为"",而非null
        );
        //4.处理中文乱码问题
        List<MediaType> fastMediaTypes = new ArrayList<>();
        fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        fastJsonHttpMessageConverter.setSupportedMediaTypes(fastMediaTypes);

        //5.将fastJsonConfig加到消息转换器中
        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
        converters.add(fastJsonHttpMessageConverter);

    }

}