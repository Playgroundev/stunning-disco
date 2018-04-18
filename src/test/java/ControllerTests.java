
import com.dita.dev.costcalculator.Controller.Utilities;
import static org.junit.Assert.assertEquals;
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
        String expectedResult = "S60";
        String result = instance.getCarModels().get(0);
        assertEquals(expectedResult,result);
        
    }
        
    
}
