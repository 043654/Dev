package lv.dong.Dev;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import static lv.dong.Dev.Go.Execute;

@Slf4j
@SpringBootApplication
public class DevApplication implements CommandLineRunner {

    public static void main(String[] args) {
//        DevApplication.Run();
        SpringApplication.run(DevApplication.class, args);

    }

    @Autowired
    private Go Go;

    @Override
    public void run(String... args) throws Exception {
        Execute();
        log.info("主程序运行完成");
    }
}
