package Steps;

import Base.BaseUtil;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hook extends BaseUtil{

    private BaseUtil base;

    public Hook(BaseUtil base){
        this.base = base;
    }
    @Before
    public void setUp(){
        System.out.println("Opening the browser");
        base.stepInfo = "chromedriver";
    }


    @After
    public void tearDown(Scenario scenario){
        if (scenario.isFailed()){
            System.out.println(scenario.getName() + "has failed");
        }
        System.out.println("Closing the browser");
    }
}


