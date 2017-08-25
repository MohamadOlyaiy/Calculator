package com.example.mohamadol.calcwithtablayout;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.SystemClock;
import android.provider.Settings;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.math.BigInteger;

import static android.content.Context.MODE_PRIVATE;


/**
 * A simple {@link Fragment} subclass.
 * SIMPLECALCULATOR FRAGMENT BY MOHAMAD OLYAIY AUG 2017
 * THE CALCULATOR ONLY ACCEPTS 2 NUMBER AT THE TIME
 * FACTORIAL INPUT SHOULD BE LESS THAN 20
 */
public class SimpleCalculatorFragment extends Fragment implements View.OnClickListener {

    //GLOBAL VARIABLES
    double answer=0;


    String firstNumber="";
    String secondNumber="";
    String oprt="";    //OPERATOR


    boolean flag=false; //FALSE=EDITING THE FIRSTNUMBER , TRUE=EDITING THE SECONDNUMBER
    boolean resultFlag=false;  //SHOWING RESULT?
    boolean sign1=false;  //SIGN  OF NUMBER1
    boolean sign2=false;  //SIGN  OF NUMBER2
    boolean rad=true;     // RAD?DEGREE


    TextView display;
    TextView mode;

    //Data storage
    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    String dataName="CalcData";



    View view;
    public SimpleCalculatorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         view=inflater.inflate(R.layout.fragment_simple_calculator, container, false);
        initialize();
         prefs =  getActivity().getSharedPreferences( dataName, Context.MODE_PRIVATE);
         editor = prefs.edit();
        firstNumber= prefs.getString("number1","");
        secondNumber=prefs.getString("number2","");
        oprt=prefs.getString("operator","");
        display.setText(firstNumber+oprt+secondNumber);
        return view;
    }




    //ONCLICK METHOD
    //ACCORDING TO THE BUTTON PRESSED, SET THE OPERATOR AND CALL THE CHECK OPERATION

    @Override
    public void onClick(View v) {

        switch(v.getId()){
            case R.id.btn0:
                if(flag)secondNumber+="0";
                else    firstNumber+="0";
                break;
            case R.id.btn1:
                if(flag)secondNumber+="1";
                else    firstNumber+="1";
                break;
            case R.id.btn2:
                if(flag)secondNumber+="2";
                else    firstNumber+="2";
                break;
            case R.id.btn3:
                if(flag)secondNumber+="3";
                else    firstNumber+="3";
                break;
            case R.id.btn4:
                if(flag)secondNumber+="4";
                else    firstNumber+="4";
                break;
            case R.id.btn5:
                if(flag)secondNumber+="5";
                else    firstNumber+="5";
                break;
            case R.id.btn6:
                if(flag)secondNumber+="6";
                else    firstNumber+="6";
                break;
            case R.id.btn7:
                if(flag)secondNumber+="7";
                else    firstNumber+="7";
                break;
            case R.id.btn8:
                if(flag)secondNumber+="8";
                else    firstNumber+="8";
                break;
            case R.id.btn9:
                if(flag)secondNumber+="9";
                else    firstNumber+="9";
                break;
            case R.id.btnpoint:
                if(flag)secondNumber+=".";
                else    firstNumber+=".";
                break;
            case R.id.btnsum:
                if(firstNumber.length()>0){
                    if(oprt=="")flag = !flag;
                    else {
                        checkOperation();
                        flag=true;
                    }
                    oprt="+";
                }
                break;
            case R.id.btnminus:
                if(firstNumber.length()>0){
                    if(oprt=="")flag = !flag;
                    else {
                        checkOperation();
                        flag=true;
                    }
                    oprt="-";
                }
                break;
            case R.id.btnmult:
                if(firstNumber.length()>0){
                    if(oprt=="")flag = !flag;
                    else {
                        checkOperation();
                        flag=true;
                    }
                    oprt="x";
                }
                break;
            case R.id.btndevide:
                if(firstNumber.length()>0){
                    if(oprt=="")flag = !flag;
                    else {
                        checkOperation();
                        flag=true;
                    }
                    oprt="/";
                }
                break;
            case R.id.btnpow:
                if(firstNumber.length()>0){
                    if(oprt=="")flag = !flag;
                    else {
                        checkOperation();
                        flag=true;
                    }
                    oprt="^";
                }
                break;


            case R.id.btnfactoriel:
                if(secondNumber.length()>0){
                    checkOperation();
                    oprt="!";
                    checkOperation();
                } else if (oprt == "" && firstNumber.length() > 0) {
                    oprt = "!";
                    checkOperation();
                }
            break;
            case R.id.btnbtnlog:
                if(secondNumber.length()>0){
                    checkOperation();
                    oprt="log";
                    checkOperation();
                } else if (oprt == "" && firstNumber.length() > 0) {
                    oprt = "log";
                    checkOperation();
                }
                break;
            case R.id.btnln:
                if(secondNumber.length()>0){
                    checkOperation();
                    oprt="ln";
                    checkOperation();
                } else if (oprt == "" && firstNumber.length() > 0) {
                    oprt = "ln";
                    checkOperation();
                }
                break;
            case R.id.btnsin:
                if(secondNumber.length()>0){
                    checkOperation();
                    oprt="sin";
                    checkOperation();
                } else if (oprt == "" && firstNumber.length() > 0) {
                    oprt = "sin";
                    checkOperation();
                }
                break;
            case R.id.btncos:
                if(secondNumber.length()>0){
                    checkOperation();
                    oprt="cos";
                    checkOperation();
                } else if (oprt == "" && firstNumber.length() > 0) {
                    oprt = "cos";
                    checkOperation();
                }
                break;
            case R.id.btnasin:
                if(secondNumber.length()>0){
                    checkOperation();
                    oprt="asin";
                    checkOperation();
                } else if (oprt == "" && firstNumber.length() > 0) {
                    oprt = "asin";
                    checkOperation();
                }
                break;
            case R.id.btnacos:
                if(secondNumber.length()>0){
                    checkOperation();
                    oprt="acos";
                    checkOperation();
                } else if (oprt == "" && firstNumber.length() > 0) {
                    oprt = "acos";
                    checkOperation();
                }
                break;
            case R.id.btnrad:
                rad=!rad;
                break;
            case R.id.btnsignn:
                if(flag){
                    if(sign2==false){
                        sign2=true;
                        secondNumber="-"+secondNumber;
                    }
                    else{
                        sign2=false;
                        secondNumber=secondNumber.substring(1,secondNumber.length());
                    }
                }
                else {
                    if(sign1==false){
                        sign1=true;
                        firstNumber="-"+firstNumber;
                    }
                    else{
                        sign1=false;
                        firstNumber=firstNumber.substring(1,firstNumber.length());
                    }
                }
                break;
            case R.id.btndlt:
                if(flag && secondNumber.length()>0) {
                    secondNumber=secondNumber.substring(0,secondNumber.length()-1);

                }
                else if(flag && oprt!=""){
                    oprt="";
                    flag=false;
                }
                else if(!flag && firstNumber.length()>0 )   firstNumber=firstNumber.substring(0,firstNumber.length()-1);
                break;
            case R.id.btnresult:
                checkOperation();
                break;
            case R.id.btnce:
                firstNumber="";
                secondNumber="";
                oprt="";
                flag=false;
                resultFlag=false;
                answer=0;
                break;

            default:
                break;
        }
        disply();


    }






    //CHECKOPERATION CHECKS THE OPERATION AND COMPUTE THE RESULT ACCORDINGLY
    private void checkOperation(){
        Double num1=0.0;
        Double num2=0.0;
        try{ num1=Double.parseDouble(firstNumber);}
        catch(NumberFormatException e){}
        try{ num2=Double.parseDouble(secondNumber);}
        catch(NumberFormatException e){}
        if(firstNumber.length()>0 && secondNumber.length()>0) {
            switch (oprt) {
                case "+":
                    answer = num1 + num2;
                    break;
                case "-":
                    answer = num1 - num2;
                    break;
                case "/":
                    answer = num1 / num2;
                    break;
                case "x":
                    answer = num1 * num2;
                    break;
                case "^":
                    answer=Math.pow(num1 , num2);
                    break;
            }
            resultFlag = true;
            firstNumber = Double.toString(answer);
            secondNumber = "";
            oprt = "";
            flag = false;
            sign2=false;
            if(answer>=0) sign1=false;
            else sign1=true;
        }
        else if(firstNumber.length()>0){
            switch(oprt){
                case "!":
                   answer=factorial(num1.intValue());
                    break;
                case "log":
                    answer=Math.log10(num1);
                    break;
                case "ln":
                    answer=Math.log(num1);
                    break;
                case "sin":
                    if(rad) answer=Math.sin(num1);
                    else    answer=Math.sin(num1*Math.PI/180.0);
                    break;
                case "cos":
                    if(rad) answer=Math.cos(num1);
                    else    answer=Math.cos(num1*Math.PI/180.0);
                    break;
                case "asin":
                    if(rad) answer=Math.asin(num1);
                    else    answer=Math.asin(num1)*180.0/Math.PI;
                    break;
                case "acos":
                    if(rad) answer=Math.acos(num1);
                    else    answer=Math.acos(num1)*180.0/Math.PI;
                    break;
            }
            resultFlag = true;
            firstNumber = Double.toString(answer);
            secondNumber = "";
            oprt = "";
            flag = false;
            sign2=false;
        }
    }



    //DISPLAY FUNCTION
    public void disply(){
        if(!resultFlag){
            display.setText(firstNumber+oprt+secondNumber);
        }
        else {
            display.setText(""+answer+oprt);
            resultFlag=false;
        }
        if(rad)mode.setText("rad");
        else mode.setText("degree");
    }











    //INITIALIZING THE BUTTONS AND TEXTVIEWS
    public void initialize(){
        display=(TextView)view.findViewById(R.id.textView);
        mode=(TextView)view.findViewById(R.id.mode);

        Button btn0=(Button)view.findViewById(R.id.btn0);
        btn0.setOnClickListener(this);
        Button btn1=(Button)view.findViewById(R.id.btn1);
        btn1.setOnClickListener(this);
        Button btn2=(Button)view.findViewById(R.id.btn2);
        btn2.setOnClickListener(this);
        Button btn3=(Button)view.findViewById(R.id.btn3);
        btn3.setOnClickListener(this);
        Button btn4=(Button)view.findViewById(R.id.btn4);
        btn4.setOnClickListener(this);
        Button btn5=(Button)view.findViewById(R.id.btn5);
        btn5.setOnClickListener(this);
        Button btn6=(Button)view.findViewById(R.id.btn6);
        btn6.setOnClickListener(this);
        Button btn7=(Button)view.findViewById(R.id.btn7);
        btn7.setOnClickListener(this);
        Button btn8=(Button)view.findViewById(R.id.btn8);
        btn8.setOnClickListener(this);
        Button btn9=(Button)view.findViewById(R.id.btn9);
        btn9.setOnClickListener(this);
        Button btnsum=(Button)view.findViewById(R.id.btnsum);
        btnsum.setOnClickListener(this);
        Button btnsubstrct=(Button)view.findViewById(R.id.btnminus);
        btnsubstrct.setOnClickListener(this);
        Button btndiv=(Button)view.findViewById(R.id.btndevide);
        btndiv.setOnClickListener(this);
        Button btnmult=(Button)view.findViewById(R.id.btnmult);
        btnmult.setOnClickListener(this);
        Button btnpow=(Button)view.findViewById(R.id.btnpow);
        btnpow.setText(Html.fromHtml("X<sup>n</sup>"));
        btnpow.setOnClickListener(this);
        Button btnsign=(Button)view.findViewById(R.id.btnsignn);
        btnsign.setOnClickListener(this);
        Button btnresult=(Button)view.findViewById(R.id.btnresult);
        btnresult.setOnClickListener(this);
        Button btnclear=(Button)view.findViewById(R.id.btnce);
        btnclear.setOnClickListener(this);
        Button btndel=(Button)view.findViewById(R.id.btndlt);
        btndel.setOnClickListener(this);
        Button btndecimal=(Button)view.findViewById(R.id.btnpoint);
        btndecimal.setOnClickListener(this);
        Button btnfactor=(Button)view.findViewById(R.id.btnfactoriel);
        btnfactor.setOnClickListener(this);
        Button btnlog=(Button)view.findViewById(R.id.btnbtnlog);
        btnlog.setOnClickListener(this);
        Button btnsin=(Button)view.findViewById(R.id.btnsin);
        btnsin.setOnClickListener(this);
        Button btncos=(Button)view.findViewById(R.id.btncos);
        btncos.setOnClickListener(this);
        Button btnln=(Button)view.findViewById(R.id.btnln);
        btnln.setOnClickListener(this);
        Button btnasin=(Button)view.findViewById(R.id.btnasin);
        btnasin.setText(Html.fromHtml("sin<sup>-1</sup>"));
        btnasin.setOnClickListener(this);
        Button btnacos=(Button)view.findViewById(R.id.btnacos);
        btnacos.setText(Html.fromHtml("cos<sup>-1</sup>"));
        btnacos.setOnClickListener(this);
        Button btnrad=(Button)view.findViewById(R.id.btnrad);
        btnrad.setOnClickListener(this);


    }
    @Override public void onPause(){
        //SAVING KEYVALUES
        editor.putString("number1", firstNumber);
        editor.putString("number2", secondNumber);
        editor.putString("operator", oprt);
        editor.putBoolean("flag",flag);
        editor.putBoolean("resultflag",resultFlag);
        editor.putBoolean("sign1",sign1);
        editor.putBoolean("sign2",sign2);
        editor.putBoolean("rad",rad);
        editor.commit();
        super.onPause();
    }
    @Override public void onStop(){
        super.onStop();
    }
    @Override public void onResume(){
        //GETTING KEYVALUES
        firstNumber= prefs.getString("number1","");
        secondNumber=prefs.getString("number2","");
        oprt=prefs.getString("operator","");
        flag=prefs.getBoolean("flag",false);
        resultFlag=prefs.getBoolean("resultflag",false);
        sign1=prefs.getBoolean("sign1",false);
        sign2=prefs.getBoolean("sign2",false);
        rad=prefs.getBoolean("rad",true);

        super.onResume();
    }


    //COMPUTING THE ! OF A NUMBER USING RECURSION
    //INPUT: INTEGER LESS THAN 20
    //OUTPUT LONG

    public long factorial(int n){
        if(n>20) return 1;
        else {
            if (n == 0 || n == 1) return 1;
            return factorial(n - 1) * n;
        }
    }

}
