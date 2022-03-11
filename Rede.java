package rede;

/**
 *
 * @author glueiriva
 */
public class Rede {

    public static boolean validarIP(String ip){
        boolean validacion=true;
        String auxiliar1, auxiliar2;
        
        int p=0;
        for (int i=0; i < ip.length();i++) {
            if (ip.charAt(i)=='.') {
                p++;
            }
        }
        
        if (p!=3) {
            validacion=false;
        } else {
            
            try{
                
                auxiliar1 = ip.substring(0,ip.indexOf('.'));
                if (Integer.parseInt(auxiliar1) > 255 || Integer.parseInt(auxiliar1) < 0 || comprobarCeros(auxiliar1)) {
                    validacion=false;
                }
                
                auxiliar2 = ip.substring(ip.indexOf('.')+1);
                auxiliar1 = auxiliar2.substring(0,auxiliar2.indexOf('.'));
                if (Integer.parseInt(auxiliar1) > 255 || Integer.parseInt(auxiliar1) < 0 || comprobarCeros(auxiliar1)) {
                    validacion=false;
                }
                
                auxiliar2 = auxiliar2.substring(auxiliar2.indexOf('.')+1);
                auxiliar1 = auxiliar2.substring(0,auxiliar2.indexOf('.'));
                if (Integer.parseInt(auxiliar1) > 255 || Integer.parseInt(auxiliar1) < 0 || comprobarCeros(auxiliar1)) {
                    validacion=false;
                }
                
                auxiliar2 = auxiliar2.substring(auxiliar2.indexOf('.')+1);
                auxiliar1 = auxiliar2;
                if (Integer.parseInt(auxiliar1) > 255 || Integer.parseInt(auxiliar1) < 0 || comprobarCeros(auxiliar1)) {
                    validacion=false;
                }
                
            }catch(Exception e){
                validacion=false;
            }
        }
        
        return validacion;
    }
    /**
    public static boolean validarMascara(String mascara){
        boolean validacion=true;
        
        int p=0;
        for (int i=0; i < mascara.length();i++) {
            if (mascara.charAt(i)=='.') {
                p++;
            }
        }
        
        if (p!=3) {
            validacion=false;
        } else {
            
            //try{
                String[] bytes = mascara.split("//.");
                String validos = "0 128 192 224 240 248 252 254 255";
                
                for (int i=0; i < 4;i++) {
                    if (!bytes[i].contains(validos)) {
                        validacion=false;
                    }
                }
                
            //}catch(Exception e){
            //    validacion=false;
            //}
        }
        
        
        
        return validacion;
    }**/
    
    
    public static boolean comprobarCeros(String bytes){
        boolean ceros=false;
        
        if (bytes.length()!= 1) {
            if (bytes.charAt(0) == '0') {
                ceros=true;
            }
        } 
        
        return ceros;
    }
    
    public static int buscarIP(String ip, String [] ips){
        int posicion=-1;
        
        if (validarIP(ip)) {
            for (int i=0; i < ips.length && posicion==-1;i++) {
                if (ips[i].equals(ip)) {
                    posicion=i;

                }
            }
        }
        return posicion;
    }
    
    public static void main(String[] args) {
        //variables
        String[] ips = {"192.168.0.9", "192.168.100.0", "255.255.255.255", "0.0.0.0"};
        String[] vacio = new String[0];
        
        System.out.println(buscarIP("192.168.100.0",ips));
        
        System.out.println(validarIP("192.168.100.0"));
        
        System.out.println(validarMascara("255.255.255.255"));
        
    }

}
