package lv.dong.Dev;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author Donglee
 * @version 1.0
 * @description: TODO
 * @date 2023/12/11 15:30
 */
@Slf4j
@Component
public class Go {
    private Go() {}
    public static void Execute() {
        System.out.println("脚本执行入口被调用了");
    }
}
