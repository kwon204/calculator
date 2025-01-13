import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {

    static Calculator cal;

    @BeforeEach
    public void setUp() {
        cal = new Calculator();
    }


    @Test
    public void addTest() {
        int i = 3;
        int j = 4;

        int result = cal.add(i, j);

        assertThat(result).isEqualTo(7);
    }

    @Test
    public void addEmptyStringTest() {
        String emptyString = "";
        String nullString = null;

        int result1 = cal.add(emptyString);
        int result2 = cal.add(nullString);

        assertThat(result1).isEqualTo(0);
        assertThat(result2).isEqualTo(0);
    }

    @Test
    public void addStringTest() {
        String input1 = "1,2";
        String input2 = "1:2";
        String input3 = "1:2,3";
        String input4 = "1: 13 , 5  ";
        String input5 = "1231";

        int result1 = cal.add(input1);
        int result2 = cal.add(input2);
        int result3 = cal.add(input3);
        int result4 = cal.add(input4);
        int result5 = cal.add(input5);

        assertThat(result1).isEqualTo(3);
        assertThat(result2).isEqualTo(3);
        assertThat(result3).isEqualTo(6);
        assertThat(result4).isEqualTo(19);
        assertThat(result5).isEqualTo(1231);
    }

    @Test
    public void addStringExceptionTest() {
        String input1 = "1%2";
        String input2 = "1!1";
        String input3 = "1@3";
        String input4 = " :1,1";
        String input5 = "1^1";
        String input6 = "1&1";
        String input7 = "1*1";
        String input8 = "1(1";
        String input9 = "1adf1";
        String input10 = "1-1";
        String input11 = "1_1";
        String input12 = "1,3:6/";

        assertThatThrownBy(() -> cal.add(input1)).isInstanceOf(NumberFormatException.class);
        assertThatThrownBy(() -> cal.add(input2)).isInstanceOf(NumberFormatException.class);
        assertThatThrownBy(() -> cal.add(input3)).isInstanceOf(NumberFormatException.class);
        assertThatThrownBy(() -> cal.add(input4)).isInstanceOf(NumberFormatException.class);
        assertThatThrownBy(() -> cal.add(input5)).isInstanceOf(NumberFormatException.class);
        assertThatThrownBy(() -> cal.add(input6)).isInstanceOf(NumberFormatException.class);
        assertThatThrownBy(() -> cal.add(input7)).isInstanceOf(NumberFormatException.class);
        assertThatThrownBy(() -> cal.add(input8)).isInstanceOf(NumberFormatException.class);
        assertThatThrownBy(() -> cal.add(input9)).isInstanceOf(NumberFormatException.class);
        assertThatThrownBy(() -> cal.add(input10)).isInstanceOf(NumberFormatException.class);
        assertThatThrownBy(() -> cal.add(input11)).isInstanceOf(NumberFormatException.class);
        assertThatThrownBy(() -> cal.add(input12)).isInstanceOf(NumberFormatException.class);
    }

    @Test
    public void subtractTest() {
        int i = 5;
        int j = 4;

        int result = cal.subtract(i, j);

        assertThat(result).isEqualTo(1);
    }

    @Test
    public void multiplyTest() {
        int i = 2;
        int j = 6;

        int result = cal.multiply(i, j);

        assertThat(result).isEqualTo(12);
    }

    @Test
    public void divideTest() {
        int i = 8;
        int j = 4;

        int result = cal.divide(i, j);

        assertThat(result).isEqualTo(2);
    }
}
