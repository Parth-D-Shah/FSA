public class Question2
{
    public static void main(String[] args) 
    {
        // DEMO code, using automaton of Figure 1

        FSA A0=generateFSA0();

        // Check and print the automaton A0
        checkPrintFSA(A0,"A0");

        // Check if A0 accepts some words
        System.out.println("accepts 001: "+isAccepted(A0,new String[]{"0","0","1"}));
        System.out.println("accepts 112: "+isAccepted(A0,new String[]{"1","1","2"}));
        System.out.println("accepts 201: "+isAccepted(A0,new String[]{"2","0","1"}));
        System.out.println("accepts epsilon: "+isAccepted(A0,new String[]{ }));

        // Check if A0 is deterministic -- the method needs to be implemented
        System.out.println("deterministic: "+isDeterministic(A0));

        // Part (b)
        System.out.println("Printout(b)");
        printThem();

        // Part (c)
        System.out.println("Printout(c)");
        runThem();

        // Part (d)
        System.out.println("Printout(d)");
        testIsDeterministic();

    }

    public static FSA generateFSA0() {
        String[] alphabet = new String[]{ "0", "1", "2" };
        Transition[] delta = new Transition[] { 
            new Transition(0,"0",0), 
            new Transition(0,"0",1),
            new Transition(0,"2",2),
            new Transition(1,"1",2),
            new Transition(2,"0",2),
            new Transition(2,"1",2)
        };
        int[] finals = new int[] { 2 };
        FSA A = new FSA(3,alphabet,delta,finals);
        return A;
    }

    public static FSA generateFSA1() {
        String[] alphabet = new String[]{ "0", "1" };
        Transition[] delta = new Transition[] 
        {
            new Transition(0,"1",0),
            new Transition(0,"1",1),
            new Transition(1,"0",2),
            new Transition(1,"1",3),
            new Transition(3,"0",5),
            new Transition(5,"1",4),
            new Transition(4,"1",6),
            new Transition(6,"1",5)
        };
        int finals[] = new int[] { 6 };
        FSA A = new FSA(7,alphabet,delta,finals);
        return A;
    }

    public static FSA generateFSA2() {
        String[] alphabet = new String[]{ "0", "1", "2" };
        Transition[] delta = new Transition[] 
        {
            new Transition(0,"2",0),
            new Transition(0,"1",1),
            new Transition(1,"1",2),
            new Transition(2,"0",3),
            new Transition(3,"1",0),
            new Transition(0,"0",4),
            new Transition(4,"1",5),
            new Transition(5,"2",0)
        };
        int finals[] = new int[] { 0,4 };
        FSA A = new FSA(6,alphabet,delta,finals);    
        return A;
    }

    public static FSA generateFSA3() {
        String[] alphabet = new String[]{ "0", "1", "3" };
        Transition[] delta = new Transition[] 
        {
            new Transition(0,"1",1),
            new Transition(0,"3",1),
            new Transition(1,"3",0),
            new Transition(1,"1",2),
            new Transition(2,"0",1),
            new Transition(2,"3",1)
        };
        int finals[] = new int[] { 1,2 };
        FSA A = new FSA(3,alphabet,delta,finals);
        return A;
    }
    
    public static void printThem() {
        FSA fsa1 = generateFSA1();
        FSA fsa2 = generateFSA2();
        FSA fsa3 = generateFSA3();
        checkPrintFSA(fsa1,"A1");
        checkPrintFSA(fsa2,"A2");
        checkPrintFSA(fsa3,"A3");
    }

    public static void runThem() {
        FSA fsa1 = generateFSA1();
        FSA fsa2 = generateFSA2();
        FSA fsa3 = generateFSA3();
        String[] a = {"1","1","0","1","1"};
        String[] b = {"1","1","0","1","0"};
        String[] c = {"1","1","0","0","1"};
        String yes = "yes";
        String no = "no";
        Boolean fsa1checka = isAccepted(fsa1,a);
        Boolean fsa1checkb = isAccepted(fsa1,b);
        Boolean fsa1checkc = isAccepted(fsa1,c);
        Boolean fsa2checka = isAccepted(fsa2,a);
        Boolean fsa2checkb = isAccepted(fsa2,b);
        Boolean fsa2checkc = isAccepted(fsa2,c);
        Boolean fsa3checka = isAccepted(fsa3,a);
        Boolean fsa3checkb = isAccepted(fsa3,b);
        Boolean fsa3checkc = isAccepted(fsa3,c);
        System.out.println();
        if(fsa1checka == true){
            System.out.print("A1 accepts: 11011 ["+yes+"]");
        }
        else{
            System.out.print("A1 accepts: 11011 ["+no+"]");
        }
        if(fsa1checkb == true){
            System.out.print(", 11010 ["+yes+"]");
        }
        else{
            System.out.print(", 11010 ["+no+"]");
        }
        if(fsa1checkc == true){
            System.out.print(", 11001 ["+yes+"]");
        }
        else{
            System.out.print(", 11001 ["+no+"]");
        }
        System.out.println();
        if(fsa2checka == true){
            System.out.print("A2 accepts: 11011 ["+yes+"]");
        }
        else{
            System.out.print("A2 accepts: 11011 ["+no+"]");
        }
        if(fsa2checkb == true){
            System.out.print(", 11010 ["+yes+"]");
        }
        else{
            System.out.print(", 11010 ["+no+"]");
        }
        if(fsa2checkc == true){
            System.out.print(", 11001 ["+yes+"]");
        }
        else{
            System.out.print(", 11001 ["+no+"]");
        }
        System.out.println();
        if(fsa3checka == true){
            System.out.print("A3 accepts: 11011 ["+yes+"]");
        }
        else{
            System.out.print("A3 accepts: 11011 ["+no+"]");
        }
        if(fsa3checkb == true){
            System.out.print(", 11010 ["+yes+"]");
        }
        else{
            System.out.print(", 11010 ["+no+"]");
        }
        if(fsa3checkc == true){
            System.out.print(", 11001 ["+yes+"]");
        }
        else{
            System.out.print(", 11001 ["+no+"]");
        }
    }

    public static Boolean isDeterministic(FSA A) {
        String[] arraystate = new String[A.delta.length];
        String[] arraytransition = new String[A.delta.length];
        for(int i = 0;i < A.delta.length;i++)
        {
            int state = A.delta[i].from;
            String state1 = Integer.toString(state);
            String transition = A.delta[i].label;
            arraystate[i] = state1;
            arraytransition[i] = transition;
        }    
        for (int i = 0; i < A.delta.length; i++) {
            for (int j = i + 1 ; j < A.delta.length; j++) { 
                if ((arraystate[i].equals(arraystate[j]))&(arraytransition[i].equals(arraytransition[j]))) 
                { 
                    return false;
                } 
            } 
        }
        return true;
    }
    // DO NOT CHANGE THE REMAINING CODE
    
    // print FSA A, after checking it is valid
    public static void checkPrintFSA(FSA A, String name) {
        if(A==null) return;
        String s = A.check();
        if(s!="") System.out.println("Error found in "+name+":\n"+s);
        else System.out.println(name+" = "+A.toString());
    }

    // check if FSA A accepts word w -- naive implementation
    public static Boolean isAccepted(FSA A, String[] w) {
        return isAcceptedRec(A,w,0,0);
    }
    
    // test the isDeterministic method on 10 FSAs
    public static void testIsDeterministic() {
        int j, marks = 0;
        Object[] X = FSA.getSamples();
        FSA[] tests = (FSA[])X[0];
        Boolean[] res = (Boolean[])X[1];
        for(int i=0; i<tests.length; i++) {
            System.out.println("Test "+(i+1)+": "+tests[i].toString());
            j = (res[i]==isDeterministic(tests[i])) ? 1 : 0;
            System.out.println("Result: "+j);
            marks += j;
        }
        System.out.println("Total: "+marks);
    }

    private static Boolean isAcceptedRec(FSA A, String[] w, int q, int i) {
        if(i==w.length) {
            for(int qF : A.finalStates)
                if(q==qF) return true;
            return false;
        }
        for(Transition t : A.delta) 
            if(t.from==q && t.label==w[i])
                if(isAcceptedRec(A,w,t.to,i+1)) return true;
        return false;
    }

    
}
