package soundsystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan  //在soundsystem包下所有带@Component注解的类都会被创建为bean
//@ComponentScan(basePackages = {"soundsystem", "video"})   //可以指定需要配置的包，否则默认所在的包为基础包（此方法类型不安全）
//@ComponentScan(basePackageClasses = {CDPlayer.class, DVDPlayer.class})    //可以指定需要配置的类，以类所在的包为基础包
public class CDPlayerConfig {

    //简单声明Bean，可以发挥Java的蓑鲉功能，只要最终生成一个CompactDisc实现
    @Bean
    public CompactDisc sgtPeppers(){
        return new SgtPeppers();
    }

    //在一组CD中随机选择一个CompactDisc来做，即可选择注入方式
    @Bean
    public CompactDisc randomBeatlesCD(){
        int choice = (int)Math.floor(Math.random() * 4);
        if(choice == 0){
            return new SgtPeppers();
        }
        /*else if(choice == 1){
            return new WhiteAlbum();
        }
        else if(choice == 2){
            return new HardDaysNight();
        }
        else{
            return new Revolver();
        }*/
        return new SgtPeppers();
    }

    //借助JavaConfig实现注入，Spring会拦截所有对它的调用，对于每次调用都会注入同一个实例
    @Bean
    public CDPlayer cdPlayer(){
        return new CDPlayer(sgtPeppers());
    }
}
