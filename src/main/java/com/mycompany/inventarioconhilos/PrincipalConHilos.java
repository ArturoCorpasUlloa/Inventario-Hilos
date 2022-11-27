
package com.mycompany.inventarioconhilos;


class GlobalVals{
   static final int Tamano = 1000; 
   //Productos
    static int [] A = new int[GlobalVals.Tamano];
   //Pedidos
    static int [] B = new int[GlobalVals.Tamano];
    //Compras
    static int [] C = new int[GlobalVals.Tamano];
    
}

class VectorA extends Thread{     
        
            
    @Override
    public void run(){
        System.out.println("Inicio hilo Productos");
        for(int i = 0; i< GlobalVals.Tamano; i++){            
            GlobalVals.A[i] = (int) (Math.random()*10000);
            System.out.println(" llenado A: " + i);           
        }
        System.out.println("Fin hilo Producto");
    }    
    
}

class VectorB extends Thread{  
    
    
    @Override    
    public void run(){
        int mayor = 0;
        System.out.println("Inicia hilo Pedidos");
        for(int i = 0; i< GlobalVals.Tamano; i++){
            GlobalVals.B[i] = (int) (Math.random()*10000);
            System.out.println(" llenado B: " + i); 
            if(GlobalVals.B[i] > mayor){
                mayor = GlobalVals.B[i];
            }            
        }
        System.out.println("Fin hilo Pedidos");
        System.out.println("El valor más alto de los pedidos es: " + mayor);
    }  
}

class VectorC {
    
    public void VectorCStock(){
          for(int i = 0; i< GlobalVals.Tamano; i++){            
            int val = 0;
            if(GlobalVals.A[i] == GlobalVals.B[i]){
                val = GlobalVals.A[i];
            }else if(GlobalVals.B[i] > GlobalVals.A[i]){
                val = 2 * (GlobalVals.B[i] - GlobalVals.A[i]);                
            }else{
                val = GlobalVals.B[i];
            }
            GlobalVals.C[i] = val;            
            System.out.println(" llenado C: " + val);                        
        }      
        
    }
    
}






public class PrincipalConHilos {

  
    public static void main(String[] args) {
        
        VectorA hilo1 = new VectorA();
        VectorB hilo2 = new VectorB();
        hilo1.start();       
        hilo2.start();
        long inicio = System.currentTimeMillis();
        
        do{
        
        }while(hilo1.isAlive()|| hilo2.isAlive());
        VectorC vc = new VectorC();
        vc.VectorCStock();       
        
        long fin = System.currentTimeMillis();
        long total = fin - inicio; 
       
        System.out.println("Tiempo de ejecución con hilos: "+ total +" milisegundos");
            
        
        
    }
    
}
