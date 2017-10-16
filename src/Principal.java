public class Principal {
    
    public static void main(String[] args) throws Exception {
//        String rua = Interface.pedeRua();
//        String cidade = Interface.pedeCidade();
//        
//        System.out.println(rua + " - " + cidade);

        Connection con = new Connection();
        con.sendGet();
        
    }
    
}
