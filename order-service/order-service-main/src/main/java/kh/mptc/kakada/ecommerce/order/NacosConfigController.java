package kh.mptc.kakada.ecommerce.order;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/nacos/config")
@RequiredArgsConstructor // auto inject
public class NacosConfigController {

    private final NacosConfigProps nacosConfigProps;

    @GetMapping
    public Map<String, Object> getConfig() {
        return Map.of(
                "serviceName", nacosConfigProps.getName(),
                "serviceBasicInfo", nacosConfigProps.getBasicInfo(),
                "serviceVersion", nacosConfigProps.getVersion()
        );
    }

    @GetMapping("secure")
    public Map<String, Object> getConfigSecure() {
        return Map.of(
                "serviceName", nacosConfigProps.getName(),
                "serviceBasicInfo", nacosConfigProps.getBasicInfo(),
                "serviceVersion", nacosConfigProps.getVersion()
        );
    }

}
