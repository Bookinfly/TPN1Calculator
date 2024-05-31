/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.tpn1calculator;

/**
 *
 * @author amado
 * TP Nº1 UNL FICH ELEMENTOS DE PROGRAMACION CALCULADORA 05/2024
 * 
 * La calculadora permite ingresar numeros que se concatenan en un StringBuffer
 * Los transformo en cada operacion para no llenar la memoria de variables ya que cambian mucho
 * 
 * el metodo guardaNum() se utiliza con los operadores y controla el primer ingreso de un numero, si no es el caso pasa al metodo operador()
 *
 * 
 * el metodo operador() utiliza un swich para evaluar el tipo de operacion a realizar entre el numero que se encuentre en la var acumulador y la var ingreso
 * ejecuta y actualiza
 * 
 * el metodo checkOperador evita errores con numeros ingresados despues de un resultado sin un operador en medio
 * 
 * los operadores =, +,-,/,* y % actualizan datos y ejecutan guardaNum() que a su vez ejecuta operador() si corresponde
 * 
 * CE reinicia
 * 
 * 
 * 
 * 
 * 
 */
public class Vista extends javax.swing.JFrame {
    double acumulador = 0;//variable que acumula el resultado
    StringBuffer ingreso = new StringBuffer();//la cadena que se va formando al ingresar numeros
    StringBuffer detalle = new StringBuffer();// otra cadena para detalle
    char oper = '!';//inicia en un case invalido para caer en default
    boolean bandera = true;//para saber si aún no se agrego un numero dejo una bandera
    boolean sinOperador = false;//bandera para controlar casos de ingreso de num dir desp del =
    
    public void checkOperador() {/**despues de un = chequeo si se ingresa un numero antes de meter un operador en medio
     * si fuera el caso reinicia
     */
        if (sinOperador) {//en ese caso se reinicia
            acumulador = 0;
            etiPantalla.setText(String.valueOf(acumulador));
            oper = '!';
            bandera = true;
            detalle.setLength(0);
            detalle.append(" ");
            etiSecond.setText(detalle.toString());
            sinOperador = false;//auqnue no tenga operador ya se reinicio y no da problema
        }
    }
    
    public void operar() {/**se encarga de ejecutar la operacion segun el operador
     * Primero actualiza la pantallita de detalles
     * Luego en base a 
     * @param oper decide que operacion realizar
     * para ellas toma el num del acumulador, el operador y transforma en num el ingreso
     * / y % cuentan con un control de errores
     * 
     *actualiza las vistas
     * busca convertir en el momento de operar para no guardar demasiadas variables
     * default controla si no hay operacion a realizar
     * 
     * siempre se actualizan datos de pantallas y variables
     */
        detalle.append(String.valueOf(ingreso));//completamos la pantallita de detalles encima de la principal
        etiSecond.setText(detalle.toString());
        
        switch(oper)
        {
            case '+':
                acumulador += Double.parseDouble(ingreso.toString());//le sumo lo ingresado a acumulador
                ingreso.setLength(0);//reinicio ingreso
                etiPantalla.setText(String.valueOf(acumulador));//muestro resultado por pantalla
                break;
            case '-':
                acumulador -= Double.parseDouble(ingreso.toString());//resto
                ingreso.setLength(0);//reinicio ingreso
                etiPantalla.setText(String.valueOf(acumulador));//muestro resultado por pantalla
                break;
            case '*': 
                if (acumulador == 0 || Double.parseDouble(ingreso.toString()) == 0){//sin tiempo descubri un error al multiplicar por 0, y así lo maneje
                    ingreso.setLength(0);
                    acumulador = 0;
                    etiPantalla.setText(String.valueOf(acumulador));
                    oper = '!';
                    bandera = true;
                }
                else {
                acumulador = acumulador * (Double.parseDouble(ingreso.toString()));//multiplico
                ingreso.setLength(0);//reinicio ingreso
                etiPantalla.setText(String.valueOf(acumulador));//muestro resultado por pantalla
                }
                break;
            case '/': 
                if (acumulador == 0 || Double.parseDouble(ingreso.toString()) == 0){
                        etiPantalla.setText("ERROR DIVICION POR 0 ERROR");
                        ingreso.setLength(0);
                        acumulador = 0;
                        oper = '!';
                        bandera = true;
                }else {
                    acumulador = acumulador / (Double.parseDouble(ingreso.toString()));//divido
                    ingreso.setLength(0);//reinicio ingreso
                    etiPantalla.setText(String.valueOf(acumulador));//muestro resultado por pantalla  
                                }
                break;
            case '%':
                if (acumulador == 0 || Double.parseDouble(ingreso.toString()) == 0){
                        etiPantalla.setText("ERROR DIVICION POR 0 ERROR");
                        ingreso.setLength(0);
                        acumulador = 0;
                        oper = '!';
                        bandera = true;
                } else {
                    acumulador = acumulador % (Double.parseDouble(ingreso.toString()));//obtengo el resto de la división
                    ingreso.setLength(0);//reinicio ingreso
                    etiPantalla.setText(String.valueOf(acumulador));//muestro resultado por pantalla
                }
                break;
            default:
                acumulador = Double.parseDouble(ingreso.toString());//el acumulador pasa a ser el ingreso
                ingreso.setLength(0);//reinicio ingreso
                etiPantalla.setText(String.valueOf(acumulador));//muestro resultado por pantalla
                detalle.setLength(0);
                etiSecond.setText(" ");
        }
    }
    
    public void guardarNum(){/**método que guarda numeros, pensado para controlar el primer ingreso
     * no opera pero actualiza datos si ese es el caso
     * sino solo pasa a operar();
     */
        if (bandera) {
            bandera = false;//evito que vuelva a pasar
            acumulador = Double.parseDouble(String.valueOf(ingreso));//primer ingreso actualiza acumulador
            ingreso.setLength(0);//reinicio ingreso
            etiPantalla.setText(String.valueOf(acumulador));//muestro resultado por pantalla
            detalle.append(String.valueOf(acumulador) + " ");//pantallita de detalles
            etiSecond.setText(detalle.toString());//pantallita de detalles
        } else {// si no es el primer ingreso procede al metodo operar
            operar();
        }
    }

    /**
     * Creates new form Vista
     */
    public Vista() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton14 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        etiView = new javax.swing.JPanel();
        etiPantalla = new javax.swing.JLabel();
        etiSecond = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btn7 = new javax.swing.JButton();
        btnIgual = new javax.swing.JButton();
        btn4 = new javax.swing.JButton();
        btn8 = new javax.swing.JButton();
        btn5 = new javax.swing.JButton();
        btn9 = new javax.swing.JButton();
        btnSum = new javax.swing.JButton();
        btn1 = new javax.swing.JButton();
        btn2 = new javax.swing.JButton();
        btnResto = new javax.swing.JButton();
        btn0 = new javax.swing.JButton();
        btnDouble = new javax.swing.JButton();
        btnDiv = new javax.swing.JButton();
        btnMult = new javax.swing.JButton();
        btnRes = new javax.swing.JButton();
        btnClean = new javax.swing.JButton();
        btn6 = new javax.swing.JButton();
        btn3 = new javax.swing.JButton();

        jButton14.setBackground(new java.awt.Color(0, 0, 0));
        jButton14.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jButton14.setForeground(new java.awt.Color(235, 235, 235));
        jButton14.setText("-");
        jButton14.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.white, java.awt.Color.black, java.awt.Color.darkGray));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 204, 204), new java.awt.Color(102, 102, 102), new java.awt.Color(0, 51, 102), new java.awt.Color(0, 0, 0)));

        etiView.setBackground(new java.awt.Color(180, 203, 150));

        etiPantalla.setFont(new java.awt.Font("SimSun-ExtB", 1, 24)); // NOI18N
        etiPantalla.setForeground(new java.awt.Color(51, 51, 51));
        etiPantalla.setText("0");

        etiSecond.setFont(new java.awt.Font("SimSun-ExtB", 1, 8)); // NOI18N
        etiSecond.setText("...");

        javax.swing.GroupLayout etiViewLayout = new javax.swing.GroupLayout(etiView);
        etiView.setLayout(etiViewLayout);
        etiViewLayout.setHorizontalGroup(
            etiViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(etiViewLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(etiViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(etiViewLayout.createSequentialGroup()
                        .addComponent(etiSecond, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(128, Short.MAX_VALUE))
                    .addGroup(etiViewLayout.createSequentialGroup()
                        .addComponent(etiPantalla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(16, 16, 16))))
        );
        etiViewLayout.setVerticalGroup(
            etiViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, etiViewLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(etiSecond)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(etiPantalla, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("TPNº1");

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 1, 10)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("U.N.L. F.I.C.H. ELEMENTOS DE PROGRAMACION");

        btn7.setBackground(new java.awt.Color(235, 235, 235));
        btn7.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        btn7.setText("7");
        btn7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.white, java.awt.Color.black, java.awt.Color.darkGray));
        btn7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn7ActionPerformed(evt);
            }
        });

        btnIgual.setBackground(new java.awt.Color(0, 0, 0));
        btnIgual.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        btnIgual.setForeground(new java.awt.Color(235, 235, 235));
        btnIgual.setText("=");
        btnIgual.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.white, java.awt.Color.black, java.awt.Color.darkGray));
        btnIgual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIgualActionPerformed(evt);
            }
        });

        btn4.setBackground(new java.awt.Color(235, 235, 235));
        btn4.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        btn4.setText("4");
        btn4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.white, java.awt.Color.black, java.awt.Color.darkGray));
        btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn4ActionPerformed(evt);
            }
        });

        btn8.setBackground(new java.awt.Color(235, 235, 235));
        btn8.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        btn8.setText("8");
        btn8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.white, java.awt.Color.black, java.awt.Color.darkGray));
        btn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn8ActionPerformed(evt);
            }
        });

        btn5.setBackground(new java.awt.Color(235, 235, 235));
        btn5.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        btn5.setText("5");
        btn5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.white, java.awt.Color.black, java.awt.Color.darkGray));
        btn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn5ActionPerformed(evt);
            }
        });

        btn9.setBackground(new java.awt.Color(235, 235, 235));
        btn9.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        btn9.setText("9");
        btn9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.white, java.awt.Color.black, java.awt.Color.darkGray));
        btn9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn9ActionPerformed(evt);
            }
        });

        btnSum.setBackground(new java.awt.Color(0, 0, 0));
        btnSum.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        btnSum.setForeground(new java.awt.Color(235, 235, 235));
        btnSum.setText("+");
        btnSum.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.white, java.awt.Color.black, java.awt.Color.darkGray));
        btnSum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSumActionPerformed(evt);
            }
        });

        btn1.setBackground(new java.awt.Color(235, 235, 235));
        btn1.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        btn1.setText("1");
        btn1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.white, java.awt.Color.black, java.awt.Color.darkGray));
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });

        btn2.setBackground(new java.awt.Color(235, 235, 235));
        btn2.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        btn2.setText("2");
        btn2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.white, java.awt.Color.black, java.awt.Color.darkGray));
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });

        btnResto.setBackground(new java.awt.Color(0, 0, 0));
        btnResto.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        btnResto.setForeground(new java.awt.Color(235, 235, 235));
        btnResto.setText("resto %");
        btnResto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.white, java.awt.Color.black, java.awt.Color.darkGray));
        btnResto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestoActionPerformed(evt);
            }
        });

        btn0.setBackground(new java.awt.Color(235, 235, 235));
        btn0.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        btn0.setText("0");
        btn0.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.white, java.awt.Color.black, java.awt.Color.darkGray));
        btn0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn0ActionPerformed(evt);
            }
        });

        btnDouble.setBackground(new java.awt.Color(235, 235, 235));
        btnDouble.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        btnDouble.setText(".");
        btnDouble.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.white, java.awt.Color.black, java.awt.Color.darkGray));
        btnDouble.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoubleActionPerformed(evt);
            }
        });

        btnDiv.setBackground(new java.awt.Color(0, 0, 0));
        btnDiv.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        btnDiv.setForeground(new java.awt.Color(235, 235, 235));
        btnDiv.setText("/");
        btnDiv.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.white, java.awt.Color.black, java.awt.Color.darkGray));
        btnDiv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDivActionPerformed(evt);
            }
        });

        btnMult.setBackground(new java.awt.Color(0, 0, 0));
        btnMult.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        btnMult.setForeground(new java.awt.Color(235, 235, 235));
        btnMult.setText("*");
        btnMult.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.white, java.awt.Color.black, java.awt.Color.darkGray));
        btnMult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMultActionPerformed(evt);
            }
        });

        btnRes.setBackground(new java.awt.Color(0, 0, 0));
        btnRes.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        btnRes.setForeground(new java.awt.Color(235, 235, 235));
        btnRes.setText("-");
        btnRes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.white, java.awt.Color.black, java.awt.Color.darkGray));
        btnRes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResActionPerformed(evt);
            }
        });

        btnClean.setBackground(new java.awt.Color(0, 0, 0));
        btnClean.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        btnClean.setForeground(new java.awt.Color(235, 235, 235));
        btnClean.setText("CE");
        btnClean.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.white, java.awt.Color.black, java.awt.Color.darkGray));
        btnClean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCleanActionPerformed(evt);
            }
        });

        btn6.setBackground(new java.awt.Color(235, 235, 235));
        btn6.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        btn6.setText("6");
        btn6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.white, java.awt.Color.black, java.awt.Color.darkGray));
        btn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn6ActionPerformed(evt);
            }
        });

        btn3.setBackground(new java.awt.Color(235, 235, 235));
        btn3.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        btn3.setText("3");
        btn3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.white, java.awt.Color.black, java.awt.Color.darkGray));
        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(etiView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btn0, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDouble, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnIgual, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btn7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btn4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(btn8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btn9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(btn5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btn6, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(btn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btn2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btn3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(1, 1, 1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnRes, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSum, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDiv, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnMult, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnClean, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnResto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(134, 134, 134))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(60, 60, 60)))
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(etiView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnResto, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSum, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRes, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDiv, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMult, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnClean, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn0, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnDouble, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btn7, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btn8, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(btn5, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btn4, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btn6, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btn9, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnIgual, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn8ActionPerformed
        // TODO add your handling code here:
        //Todos los num son similares
        checkOperador();//reviso si se ingreso dir despues del igual
        ingreso.append('8');//agrego num al StringBuffer
        etiPantalla.setText(ingreso.toString());//actualizo pantalla
    }//GEN-LAST:event_btn8ActionPerformed

    private void btnRestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestoActionPerformed
        // TODO add your handling code here:
        //explico los botones de operaciones mas abajo
        sinOperador = false;
        oper = '%';
        guardarNum();
        detalle.append(String.valueOf(" " + oper + " "));
        etiSecond.setText(detalle.toString());
    }//GEN-LAST:event_btnRestoActionPerformed

    private void btnCleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCleanActionPerformed
        // TODO add your handling code here:
        //reiniciamos todo
        sinOperador = false;//aunque no tenga no afecta
        ingreso.setLength(0);
        acumulador = 0;
        etiPantalla.setText(String.valueOf(acumulador));
        oper = '!';
        bandera = true;
        detalle.setLength(0);
        detalle.append(" ");
        etiSecond.setText(detalle.toString());
    }//GEN-LAST:event_btnCleanActionPerformed

    private void btn7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn7ActionPerformed
        // TODO add your handling code here:
        checkOperador();
        ingreso.append('7');//agrego el num
        etiPantalla.setText(ingreso.toString());//muestro por pantalla
    }//GEN-LAST:event_btn7ActionPerformed

    private void btn9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn9ActionPerformed
        // TODO add your handling code here:
        checkOperador();
        ingreso.append('9');
        etiPantalla.setText(ingreso.toString());

    }//GEN-LAST:event_btn9ActionPerformed

    private void btn6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn6ActionPerformed
        // TODO add your handling code here:
        checkOperador();
        ingreso.append('6');
        etiPantalla.setText(ingreso.toString());

    }//GEN-LAST:event_btn6ActionPerformed

    private void btn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn5ActionPerformed
        // TODO add your handling code here:
        checkOperador();
        ingreso.append('5');
        etiPantalla.setText(ingreso.toString());

    }//GEN-LAST:event_btn5ActionPerformed

    private void btn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn4ActionPerformed
        // TODO add your handling code here:
        checkOperador();
        ingreso.append('4');
        etiPantalla.setText(ingreso.toString());      
    }//GEN-LAST:event_btn4ActionPerformed

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        // TODO add your handling code here:
        checkOperador();
        ingreso.append('1');
        etiPantalla.setText(ingreso.toString());

    }//GEN-LAST:event_btn1ActionPerformed

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed
        // TODO add your handling code here:
        checkOperador();
        ingreso.append('2');
        etiPantalla.setText(ingreso.toString());

    }//GEN-LAST:event_btn2ActionPerformed

    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3ActionPerformed
        // TODO add your handling code here:
        checkOperador();
        ingreso.append('3');
        etiPantalla.setText(ingreso.toString());
        
    }//GEN-LAST:event_btn3ActionPerformed

    private void btnSumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSumActionPerformed
        // TODO add your handling code here:
        //Los botones de operaciones son similares
        sinOperador = false;//quito la bandera si la hubiese
        oper = '+';//designo char
        guardarNum();//nétodo que chequea primer ingreso y si no pasa a operar
        detalle.append(String.valueOf(" " + oper + " "));//actualizo pantallita de detalle
        etiSecond.setText(detalle.toString());//actualizo pantallita de detalle
    }//GEN-LAST:event_btnSumActionPerformed

    private void btnResActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResActionPerformed
        // TODO add your handling code here:
        sinOperador = false;
        oper = '-';//asigno la operacion
        guardarNum();
        detalle.append(String.valueOf(" " + oper + " "));
        etiSecond.setText(detalle.toString());
    }//GEN-LAST:event_btnResActionPerformed

    private void btnDivActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDivActionPerformed
        // TODO add your handling code here:
        sinOperador = false;
        oper = '/';
        guardarNum();
        detalle.append(String.valueOf(" " + oper + " "));
        etiSecond.setText(detalle.toString());
    }//GEN-LAST:event_btnDivActionPerformed

    private void btnMultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMultActionPerformed
        // TODO add your handling code here:
        sinOperador = false;
        oper = '*';
        guardarNum();
        detalle.append(String.valueOf(" " + oper + " "));
        etiSecond.setText(detalle.toString());
    }//GEN-LAST:event_btnMultActionPerformed

    private void btnDoubleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoubleActionPerformed
        // TODO add your handling code here:
        checkOperador();
        if (!ingreso.toString().contains(".")){//paso el buffer a String y verifico si contiene un punto, pero uso not "!" para dar vuelta el resultado, entonces chequeo si no tiene un punto "."
            ingreso.append('.');//anexo punto al final del buffer
            etiPantalla.setText(ingreso.toString());//actualizo el out
        }
    }//GEN-LAST:event_btnDoubleActionPerformed

    private void btnIgualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIgualActionPerformed
        // TODO add your handling code here:
        guardarNum(); //operación que verifica primer ingreso y de no ser así pasa al método que realiza las operaciones.   
        oper = '!';//prepara para que operador caiga en default si no se agrega otro operador (creo que ya no hace falta pero me quede sin tiempo)
        sinOperador = true;//pone bandera de que aún no hay operador tras el resultado para una nueva operacion
    }//GEN-LAST:event_btnIgualActionPerformed

    private void btn0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn0ActionPerformed
        // TODO add your handling code here:
        checkOperador();
        ingreso.append('0');
        etiPantalla.setText(ingreso.toString());
    }//GEN-LAST:event_btn0ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn0;
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn2;
    private javax.swing.JButton btn3;
    private javax.swing.JButton btn4;
    private javax.swing.JButton btn5;
    private javax.swing.JButton btn6;
    private javax.swing.JButton btn7;
    private javax.swing.JButton btn8;
    private javax.swing.JButton btn9;
    private javax.swing.JButton btnClean;
    private javax.swing.JButton btnDiv;
    private javax.swing.JButton btnDouble;
    private javax.swing.JButton btnIgual;
    private javax.swing.JButton btnMult;
    private javax.swing.JButton btnRes;
    private javax.swing.JButton btnResto;
    private javax.swing.JButton btnSum;
    private javax.swing.JLabel etiPantalla;
    private javax.swing.JLabel etiSecond;
    private javax.swing.JPanel etiView;
    private javax.swing.JButton jButton14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    private void swich(char operation) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
