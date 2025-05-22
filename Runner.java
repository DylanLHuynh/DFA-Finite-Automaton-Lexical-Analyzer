public class Runner {
    public static void main(String[] args) {
        try {
            System.out.println(LexicalAnalyser.analyse("514 + 44 804 + 3"));
        }
        catch (NumberException e) {

        }
        catch (ExpressionException e) {
            
        }
    }
}
