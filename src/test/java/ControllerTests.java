
import com.dita.dev.costcalculator.Controller.Utilities;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author brian-kamau
 */
public class ControllerTests {
    
    @Test
    public void testCaseResults(){
        Utilities instance = new Utilities();
        System.out.println("Testing Cases");
        System.out.println(instance.getCarModels());
    }
        
    
}
