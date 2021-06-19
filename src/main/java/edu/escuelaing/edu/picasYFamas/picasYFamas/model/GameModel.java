package edu.escuelaing.edu.picasYFamas.picasYFamas.model;

import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GameModel {
    private int famas;
    private List<String> intentos = new ArrayList<>();
    private int picas;

    private String numberTry;
    private int randomNum;
    public GameModel() {

        picas = 0;
        famas = 0;
        numberTry = null;
        randomNum =(int) (1000*Math.random());

    }
    public void picasFamas(String number){
        famas = 0;
        picas=0;
        String ram = Integer.toString(randomNum);
        for( int i = 0; i < number.length();i++){
            int pos = ram.indexOf(number.charAt(i));
            if(pos >=0){
                if(pos >=0 && pos == i){
                    famas++;
                }else if(pos >=0 && pos != i){
                    picas++;
                }
            }
        }
    }
    public int getFamas() {
        return famas;
    }

    public List<String> getIntentos() {
        return intentos;
    }

    public int getPicas() {
        return picas;
    }

    public String getNumberTry() {
        return numberTry;
    }

    public int getRandomNum() {
        return randomNum;
    }


    public void restart (){
        intentos.clear();
        picas = 0;
        famas = 0;
        randomNum =(int) (1000*Math.random());
    }

}
