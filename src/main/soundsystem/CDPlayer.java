package soundsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CDPlayer implements MediaPlayer {
    private CompactDisc cd;

    //@Inject Inject是javax依赖注入规范的自动装配，和Autowired几乎可以互相替换
    @Autowired  //通过Autowired（自动装配），将一个CompactDisc注入到CDPlayer之中
    public CDPlayer(CompactDisc cd){
        this.cd = cd;
    }

    public void play(){
        cd.play();
    }

    @Autowired  //Autowired注解可用在类的任何方法上
    public void setCompactDisc(CompactDisc cd){
        this.cd = cd;
    }

    @Autowired(required=false)  //Spring都会尝试满足方法参数上所声明的依赖，如果有且只有一个bean匹配依赖，将会被装配进来
                                // 如果没有匹配将会报异常，除非设置required=false，但可能出现NullPointerException异常
                                //如果有多个bean满足依赖，将会报异常
    public void insertDisc(CompactDisc cd){
        this.cd = cd;
    }
}
