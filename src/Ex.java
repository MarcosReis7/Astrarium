
import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;


import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Ex extends JPanel{	
	Container c1;
	JPanel pnInicio;
	JButton bt1, bt2, bt3, bt4, bt5, bt6;
	JLabel astrarium,pos1,pos2, pos3, pos4, pos5, pos6, pos7;
	ImageIcon imgAstrarium, bt, imgPos1, imgPos2, imgPos3, imgPos4, imgPos5, imgPos6, imgPos7;
	
	public Ex(){
		game();
		definirEventos();
			
	}

	public void game(){

		setLayout(null);
		
		// Menu_Inicial
				
		imgAstrarium = new ImageIcon("fase1.png");
		astrarium = new JLabel(imgAstrarium);
		astrarium.setBounds(350, 0, 600, 800);
		
		imgPos1 = new ImageIcon("pos5.png");
		pos1 = new JLabel(imgPos1);
		pos1.setVisible(false);
		pos1.setBounds(503, 255, 68, 46);
		
		imgPos2 = new ImageIcon("pos3.png");
		pos2 = new JLabel(imgPos2);
		pos2.setVisible(false);
		pos2.setBounds(589, 239, 67, 12);
		
		imgPos3 = new ImageIcon("pos1.png");
		pos3 = new JLabel(imgPos3);
		pos3.setVisible(false);
		pos3.setBounds(610, 78, 54, 154);
		
		imgPos4 = new ImageIcon("pos2.png");
		pos4 = new JLabel(imgPos4);
		pos4.setVisible(false);
		pos4.setBounds(576, 78, 34, 161);
		
		imgPos5 = new ImageIcon("pos7.png");
		pos5 = new JLabel(imgPos5);
		pos5.setVisible(false);
		pos5.setBounds(576, 111, 81, 740);
		
		imgPos6 = new ImageIcon("pos6.png");
		pos6 = new JLabel(imgPos6);
		pos6.setVisible(false);
		pos6.setBounds(658, 135, 12, 682);
		
		imgPos7 = new ImageIcon("pos4.png");
		pos7 = new JLabel(imgPos7);
		pos7.setVisible(false);
		pos7.setBounds(675, 242, 53, 42);
		
		
		
		
		bt1 = new JButton();
		bt1.setBorder(null);
		bt1.setOpaque(false);
		bt1.setContentAreaFilled(false);
		bt1.setBorderPainted(false);
		bt1.setBounds(485, 295, 15, 15);
		
		bt2 = new JButton();
		bt2.setBorder(null);
		bt2.setOpaque(false);
		bt2.setContentAreaFilled(false);
		bt2.setBorderPainted(false);
		bt2.setBounds(570, 240, 15, 15);
		
		bt3 = new JButton();
		bt3.setBorder(null);
		bt3.setOpaque(false);
		bt3.setContentAreaFilled(false);
		bt3.setBorderPainted(false);
		bt3.setBounds(658, 232, 15, 15);
		
		bt4 = new JButton();
		bt4.setBorder(null);
		bt4.setOpaque(false);
		bt4.setContentAreaFilled(false);
		bt4.setBorderPainted(false);
		bt4.setBounds(605, 63, 15, 15);

		bt5 = new JButton();
		bt5.setBorder(null);
		bt5.setOpaque(false);
		bt5.setContentAreaFilled(false);
		bt5.setBorderPainted(false);
		bt5.setBounds(728, 278, 150, 150);
		bt5.setBounds(653, 703, 15, 15);
		
		bt6 = new JButton();
		bt6.setBorder(null);
		bt6.setOpaque(false);
		bt6.setContentAreaFilled(false);
		bt6.setBorderPainted(false);
		bt6.setBounds(653, 703, 15, 15);
		bt6.setBounds(728, 278, 150, 150);


		
		
		
		// Background
		
		pnInicio = new JPanel();
		pnInicio.setLayout(null);
		pnInicio.setBounds(0, 0, 2000, 2000);
		pnInicio.setBackground(Color.black);
		
		add(pos1);
		add(pos2);
		add(pos3);
		add(pos4);
		add(pos5);
		add(pos6);
		add(pos7);
	
		add(bt1);
		add(bt2);
		add(bt3);
		add(bt4);	
		add(bt5);
		add(bt6);	

		add(astrarium);
		
		add(pnInicio);
					
	}

	public void definirEventos(){
		BD bd = new BD();
		bt1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				System.out.println("1");
				if (bd.getConnection()) {
					
					try {
						
						String consulta_1 = "SELECT bt_clic FROM astrarium";
						PreparedStatement cons_1 = bd.c.prepareStatement(consulta_1);
						ResultSet rs_1 = cons_1.executeQuery();
						
						
						
						while (rs_1.next()) {
							int bt_clic = rs_1.getInt("bt_clic");
							
							if (bt_clic == 0) {
								System.out.println("primeiro botão clicado");
								String updt_1 = "UPDATE astrarium SET bt_clic = 1";
								PreparedStatement up = bd.c.prepareStatement(updt_1);
								int updt = up.executeUpdate();
								
							}
							if (bt_clic != 0) {
								String consulta_2 = "SELECT bt_clic FROM astrarium";
								PreparedStatement cons_2 = bd.c.prepareStatement(consulta_2);
								ResultSet rs_2 = cons_2.executeQuery();
								
								String updt_1 = "UPDATE astrarium SET bt_atual = 1";
								PreparedStatement up = bd.c.prepareStatement(updt_1);
								int updt = up.executeUpdate();
								
								String consulta_3 = "SELECT bt_atual FROM astrarium";
								PreparedStatement cons_3 = bd.c.prepareStatement(consulta_3);
								ResultSet rs_3 = cons_3.executeQuery();
								
								while(rs_2.next()) {
									int bt_clic_2 = rs_1.getInt("bt_clic");
									System.out.println("o botão que foi clicado antes foi o: "+ bt_clic_2);
									while(rs_3.next()) {
										int bt_clic_3 = rs_3.getInt("bt_atual");
										System.out.println("o botão que foi clicado agora foi o: "+ bt_clic_3);
										
										if (bt_clic_2 == 2 & bt_clic_3 == 1 & pos1.isVisible() == false|| bt_clic_2 == 1 & bt_clic_3 == 2 & pos1.isVisible() == false) {
											pos1.setVisible(true);
										}else if(bt_clic_2 == 2 & bt_clic_3 == 1 & pos1.isVisible() == true|| bt_clic_2 == 1 & bt_clic_3 == 2 & pos1.isVisible() == true) {
											System.out.println("Linha já estabelecida");										
										}else {
											System.out.println("Botão fora de alcance");
										}
										String updt_2 = "UPDATE astrarium SET bt_atual = 1";
										PreparedStatement up_2 = bd.c.prepareStatement(updt_2);
										int updt_22 = up_2.executeUpdate();
									}
								}
							}
						}
						rs_1.close();
						cons_1.close();
						bd.close();
					} catch (SQLException erro) {
					}
				} else {
					System.out.println("Erro ao conectar!");
				}	
			}
		});
		
		bt2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				System.out.println("2");
				if (bd.getConnection()) {
					
					try {
						
						String consulta_1 = "SELECT bt_clic FROM astrarium";
						PreparedStatement cons_1 = bd.c.prepareStatement(consulta_1);
						ResultSet rs_1 = cons_1.executeQuery();
						
						
						
						while (rs_1.next()) {
							int bt_clic = rs_1.getInt("bt_clic");
							
							if (bt_clic == 0) {
								System.out.println("primeiro botão clicado");
								String updt_1 = "UPDATE astrarium SET bt_clic = 2";
								PreparedStatement up = bd.c.prepareStatement(updt_1);
								int updt = up.executeUpdate();
								
							}
							if (bt_clic != 0) {
								String consulta_2 = "SELECT bt_clic FROM astrarium";
								PreparedStatement cons_2 = bd.c.prepareStatement(consulta_2);
								ResultSet rs_2 = cons_2.executeQuery();
								
								String updt_1 = "UPDATE astrarium SET bt_atual = 2";
								PreparedStatement up = bd.c.prepareStatement(updt_1);
								int updt_12 = up.executeUpdate();
								
								String consulta_3 = "SELECT bt_atual FROM astrarium";
								PreparedStatement cons_3 = bd.c.prepareStatement(consulta_3);
								ResultSet rs_3 = cons_3.executeQuery();
								
								while(rs_2.next()) {
									int bt_clic_2 = rs_1.getInt("bt_clic");
									System.out.println("o botão que foi clicado antes foi o: "+ bt_clic_2);
									while(rs_3.next()) {
										int bt_clic_3 = rs_3.getInt("bt_atual");
										System.out.println("o botão que foi clicado agora foi o: "+ bt_clic_3);
										if (bt_clic_2 == 2 & bt_clic_3 == 1 & pos1.isVisible() == false|| bt_clic_2 == 1 & bt_clic_3 == 2 & pos1.isVisible() == false) {
											pos1.setVisible(true);
										}else if(bt_clic_2 == 2 & bt_clic_3 == 1 & pos1.isVisible() == true|| bt_clic_2 == 1 & bt_clic_3 == 2 & pos1.isVisible() == true) {
											System.out.println("Linha já estabelecida");										
										}else {
											System.out.println("Botão fora de alcance");
										}
										
										if (bt_clic_2 == 2 & bt_clic_3 == 3 & pos2.isVisible() == false|| bt_clic_2 == 3 & bt_clic_3 == 2 & pos2.isVisible() == false) {
											pos2.setVisible(true);
										}else if(bt_clic_2 == 2 & bt_clic_3 == 3 & pos2.isVisible() == true|| bt_clic_2 == 3 & bt_clic_3 == 2 & pos2.isVisible() == true) {
											System.out.println("Linha já estabelecida");										
										}else {
											System.out.println("Botão fora de alcance");
										}
										
										if (bt_clic_2 == 2 & bt_clic_3 == 4 & pos4.isVisible() == false|| bt_clic_2 == 4 & bt_clic_3 == 2 & pos4.isVisible() == false) {
											pos4.setVisible(true);
										}else if(bt_clic_2 == 2 & bt_clic_3 == 4 & pos4.isVisible() == true|| bt_clic_2 == 4 & bt_clic_3 == 2 & pos4.isVisible() == true) {
											System.out.println("Linha já estabelecida");										
										}else {
											System.out.println("Botão fora de alcance");
										}
										
										if (bt_clic_2 == 2 & bt_clic_3 == 5 & pos5.isVisible() == false|| bt_clic_2 == 5 & bt_clic_3 == 2 & pos5.isVisible() == false) {
											pos5.setVisible(true);
										}else if(bt_clic_2 == 2 & bt_clic_3 == 5 & pos5.isVisible() == true|| bt_clic_2 == 5 & bt_clic_3 == 2 & pos5.isVisible() == true) {
											System.out.println("Linha já estabelecida");										
										}else {
											System.out.println("Botão fora de alcance");
										}
										String updt_2 = "UPDATE astrarium SET bt_clic = 2";
										PreparedStatement up_2 = bd.c.prepareStatement(updt_2);
										int updt_22 = up_2.executeUpdate();
									}
								}
							}
                        }
							
							
						
						rs_1.close();
						cons_1.close();
						bd.close();
					} catch (SQLException erro) {
					}
				} else {
					System.out.println("Erro ao conectar!");
				}
			}
		});
		
		bt3	.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				System.out.println("3");
				if (bd.getConnection()) {
					
					try {
						
						String consulta_1 = "SELECT bt_clic FROM astrarium";
						PreparedStatement cons_1 = bd.c.prepareStatement(consulta_1);
						ResultSet rs_1 = cons_1.executeQuery();
						
						
						
						while (rs_1.next()) {
							int bt_clic = rs_1.getInt("bt_clic");
							
							if (bt_clic == 0) {
								System.out.println("primeiro botão clicado");
								String updt_1 = "UPDATE astrarium SET bt_clic = 3";
								PreparedStatement up = bd.c.prepareStatement(updt_1);
								int updt = up.executeUpdate();
								
							}
							if (bt_clic != 0) {
								String consulta_2 = "SELECT bt_clic FROM astrarium";
								PreparedStatement cons_2 = bd.c.prepareStatement(consulta_2);
								ResultSet rs_2 = cons_2.executeQuery();
								
								String updt_1 = "UPDATE astrarium SET bt_atual = 3";
								PreparedStatement up = bd.c.prepareStatement(updt_1);
								int updt = up.executeUpdate();
								
								String consulta_3 = "SELECT bt_atual FROM astrarium";
								PreparedStatement cons_3 = bd.c.prepareStatement(consulta_3);
								ResultSet rs_3 = cons_3.executeQuery();
								
								while(rs_2.next()) {
									int bt_clic_2 = rs_1.getInt("bt_clic");
									System.out.println("o botão que foi clicado antes foi o: "+ bt_clic_2);
									while(rs_3.next()) {
										int bt_clic_3 = rs_3.getInt("bt_atual");
										System.out.println("o botão que foi clicado agora foi o: "+ bt_clic_3);
										if (bt_clic_2 == 3 & bt_clic_3 == 6 & pos7.isVisible() == false|| bt_clic_2 == 6 & bt_clic_3 == 3 & pos7.isVisible() == false) {
											pos7.setVisible(true);
										}else if(bt_clic_2 == 3 & bt_clic_3 == 6 & pos7.isVisible() == true|| bt_clic_2 == 6 & bt_clic_3 == 3 & pos7.isVisible() == true) {
											System.out.println("Linha já estabelecida");										
										}else {
											System.out.println("Botão fora de alcance");
										}
										
										if (bt_clic_2 == 3 & bt_clic_3 == 4 & pos3.isVisible() == false|| bt_clic_2 == 4 & bt_clic_3 == 3 & pos3.isVisible() == false) {
											pos3.setVisible(true);
										}else if(bt_clic_2 == 3 & bt_clic_3 == 4 & pos3.isVisible() == true|| bt_clic_2 == 4 & bt_clic_3 == 3 & pos3.isVisible() == true) {
											System.out.println("Linha já estabelecida");										
										}else {
											System.out.println("Botão fora de alcance");
										}
										
										if (bt_clic_2 == 3 & bt_clic_3 == 2 & pos2.isVisible() == false|| bt_clic_2 == 2 & bt_clic_3 == 3 & pos2.isVisible() == false) {
											pos2.setVisible(true);
										}else if(bt_clic_2 == 3 & bt_clic_3 == 2 & pos2.isVisible() == true|| bt_clic_2 == 2 & bt_clic_3 == 3 & pos2.isVisible() == true) {
											System.out.println("Linha já estabelecida");										
										}else {
											System.out.println("Botão fora de alcance");
										}
										
										if (bt_clic_2 == 3 & bt_clic_3 == 5 & pos6.isVisible() == false|| bt_clic_2 == 5 & bt_clic_3 == 3 & pos6.isVisible() == false) {
											pos6.setVisible(true);
										}else if(bt_clic_2 == 3 & bt_clic_3 == 5 & pos6.isVisible() == true|| bt_clic_2 == 5 & bt_clic_3 == 3 & pos6.isVisible() == true) {
											System.out.println("Linha já estabelecida");										
										}else {
											System.out.println("Botão fora de alcance");
										}
										String updt_2 = "UPDATE astrarium SET bt_clic = 3";
										PreparedStatement up_2 = bd.c.prepareStatement(updt_2);
										int updt_22 = up_2.executeUpdate();
										}
									}
								}
							}
							
							
						
						rs_1.close();
						cons_1.close();
						bd.close();
					} catch (SQLException erro) {
					}
				}
			}
		});
		
		bt4	.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				System.out.println("4");

				if (bd.getConnection()) {
					
					try {
						
						String consulta_1 = "SELECT bt_clic FROM astrarium";
						PreparedStatement cons_1 = bd.c.prepareStatement(consulta_1);
						ResultSet rs_1 = cons_1.executeQuery();
						
						
						
						while (rs_1.next()) {
							int bt_clic = rs_1.getInt("bt_clic");
							
							if (bt_clic == 0) {
								System.out.println("primeiro botão clicado");
								String updt_1 = "UPDATE astrarium SET bt_clic = 4";
								PreparedStatement up = bd.c.prepareStatement(updt_1);
								int updt = up.executeUpdate();
								
							}
							if (bt_clic != 0) {
								String consulta_2 = "SELECT bt_clic FROM astrarium";
								PreparedStatement cons_2 = bd.c.prepareStatement(consulta_2);
								ResultSet rs_2 = cons_2.executeQuery();
								
								String updt_1 = "UPDATE astrarium SET bt_atual = 4";
								PreparedStatement up = bd.c.prepareStatement(updt_1);
								int updt = up.executeUpdate();
								
								String consulta_3 = "SELECT bt_atual FROM astrarium";
								PreparedStatement cons_3 = bd.c.prepareStatement(consulta_3);
								ResultSet rs_3 = cons_3.executeQuery();
								
								while(rs_2.next()) {
									int bt_clic_2 = rs_1.getInt("bt_clic");
									System.out.println("o botão que foi clicado antes foi o: "+ bt_clic_2);
									while(rs_3.next()) {
										int bt_clic_3 = rs_3.getInt("bt_atual");
										System.out.println("o botão que foi clicado agora foi o: "+ bt_clic_3);
										if (bt_clic_2 == 4 & bt_clic_3 == 2 & pos4.isVisible() == false|| bt_clic_2 == 2 & bt_clic_3 == 4 & pos4.isVisible() == false) {
											pos4.setVisible(true);
										}else if(bt_clic_2 == 4 & bt_clic_3 == 2 & pos4.isVisible() == true|| bt_clic_2 == 2 & bt_clic_3 == 4 & pos4.isVisible() == true) {
											System.out.println("Linha já estabelecida");										
										}else {
											System.out.println("Botão fora de alcance");
										}
										
										if (bt_clic_2 == 4 & bt_clic_3 == 3 & pos3.isVisible() == false|| bt_clic_2 == 3 & bt_clic_3 == 4 & pos3.isVisible() == false) {
											pos3.setVisible(true);
										}else if(bt_clic_2 == 4 & bt_clic_3 == 3 & pos3.isVisible() == true|| bt_clic_2 == 3 & bt_clic_3 == 4 & pos3.isVisible() == true) {
											System.out.println("Linha já estabelecida");										
										}else {
											System.out.println("Botão fora de alcance");
										}
										String updt_2 = "UPDATE astrarium SET bt_clic = 4";
										PreparedStatement up_2 = bd.c.prepareStatement(updt_2);
										int updt_22 = up_2.executeUpdate();
									}
								}
							}
							
							
						}
						rs_1.close();
						cons_1.close();
						bd.close();
					} catch (SQLException erro) {
					}
				}
			}
		});
		
		bt5	.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				System.out.println("5");

				if (bd.getConnection()) {
					
					try {
						
						String consulta_1 = "SELECT bt_clic FROM astrarium";
						PreparedStatement cons_1 = bd.c.prepareStatement(consulta_1);
						ResultSet rs_1 = cons_1.executeQuery();
						
						
						
						while (rs_1.next()) {
							int bt_clic = rs_1.getInt("bt_clic");
							
							if (bt_clic == 0) {
								System.out.println("primeiro botão clicado");
								String updt_1 = "UPDATE astrarium SET bt_clic = 5";
								PreparedStatement up = bd.c.prepareStatement(updt_1);
								int updt = up.executeUpdate();
								
							}
							if (bt_clic != 0) {
								String consulta_2 = "SELECT bt_clic FROM astrarium";
								PreparedStatement cons_2 = bd.c.prepareStatement(consulta_2);
								ResultSet rs_2 = cons_2.executeQuery();
								
								String updt_1 = "UPDATE astrarium SET bt_atual = 5";
								PreparedStatement up = bd.c.prepareStatement(updt_1);
								int updt = up.executeUpdate();
								
								String consulta_3 = "SELECT bt_atual FROM astrarium";
								PreparedStatement cons_3 = bd.c.prepareStatement(consulta_3);
								ResultSet rs_3 = cons_3.executeQuery();
								
								while(rs_2.next()) {
									int bt_clic_2 = rs_1.getInt("bt_clic");
									System.out.println("o botão que foi clicado antes foi o: "+ bt_clic_2);
									while(rs_3.next()) {
										int bt_clic_3 = rs_3.getInt("bt_atual");
										System.out.println("o botão que foi clicado agora foi o: "+ bt_clic_3);
										if (bt_clic_2 == 5 & bt_clic_3 == 2 & pos5.isVisible() == false|| bt_clic_2 == 2 & bt_clic_3 == 5 & pos5.isVisible() == false) {
											pos5.setVisible(true);
										}else if(bt_clic_2 == 5 & bt_clic_3 == 2 & pos5.isVisible() == true|| bt_clic_2 == 2 & bt_clic_3 == 5 & pos5.isVisible() == true) {
											System.out.println("Linha já estabelecida");										
										}else {
											System.out.println("Botão fora de alcance");
										}
										
										if (bt_clic_2 == 5 & bt_clic_3 == 3 & pos6.isVisible() == false|| bt_clic_2 == 3 & bt_clic_3 == 5 & pos6.isVisible() == false) {
											pos6.setVisible(true);
										}else if(bt_clic_2 == 5 & bt_clic_3 == 3 & pos6.isVisible() == true|| bt_clic_2 == 3 & bt_clic_3 == 5 & pos6.isVisible() == true) {
											System.out.println("Linha já estabelecida");										
										}else {
											System.out.println("Botão fora de alcance");
										}
										String updt_2 = "UPDATE astrarium SET bt_clic = 5";
										PreparedStatement up_2 = bd.c.prepareStatement(updt_2);
										int updt_22 = up_2.executeUpdate();
									}
								}
							}
							
							
						}
						rs_1.close();
						cons_1.close();
						bd.close();
					} catch (SQLException erro) {
					}
				}
			}
		});
		
		bt6	.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				System.out.println("6");

				if (bd.getConnection()) {
					
					try {
						
						String consulta_1 = "SELECT bt_clic FROM astrarium";
						PreparedStatement cons_1 = bd.c.prepareStatement(consulta_1);
						ResultSet rs_1 = cons_1.executeQuery();
						
						
						
						while (rs_1.next()) {
							int bt_clic = rs_1.getInt("bt_clic");
							
							if (bt_clic == 0) {
								System.out.println("primeiro botão clicado");
								String updt_1 = "UPDATE astrarium SET bt_clic = 6";
								PreparedStatement up = bd.c.prepareStatement(updt_1);
								int updt = up.executeUpdate();
								
							}
							if (bt_clic != 0) {
								String consulta_2 = "SELECT bt_clic FROM astrarium";
								PreparedStatement cons_2 = bd.c.prepareStatement(consulta_2);
								ResultSet rs_2 = cons_2.executeQuery();
								
								String updt_1 = "UPDATE astrarium SET bt_atual = 6";
								PreparedStatement up = bd.c.prepareStatement(updt_1);
								int updt = up.executeUpdate();
								
								String consulta_3 = "SELECT bt_atual FROM astrarium";
								PreparedStatement cons_3 = bd.c.prepareStatement(consulta_3);
								ResultSet rs_3 = cons_3.executeQuery();
								
								while(rs_2.next()) {
									int bt_clic_2 = rs_1.getInt("bt_clic");
									System.out.println("o botão que foi clicado antes foi o: "+ bt_clic_2);
									while(rs_3.next()) {
										int bt_clic_3 = rs_3.getInt("bt_atual");
										System.out.println("o botão que foi clicado agora foi o: "+ bt_clic_3);
										if (bt_clic_2 == 6 & bt_clic_3 == 3 & pos7.isVisible() == false|| bt_clic_2 == 3 & bt_clic_3 == 6 & pos7.isVisible() == false) {
											pos7.setVisible(true);
										}else if(bt_clic_2 == 6 & bt_clic_3 == 3 & pos7.isVisible() == true|| bt_clic_2 == 3 & bt_clic_3 == 6 & pos7.isVisible() == true) {
											System.out.println("Linha já estabelecida");										
										}else {
											System.out.println("Botão fora de alcance");
										}
										String updt_2 = "UPDATE astrarium SET bt_clic = 6";
										PreparedStatement up_2 = bd.c.prepareStatement(updt_2);
										int updt_22 = up_2.executeUpdate();
									}
								}
							}
							
							
						}
						rs_1.close();
						cons_1.close();
						bd.close();
					} catch (SQLException erro) {
					}
				}
			}
		});
		
		
				
			}
		
	
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
	 	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 	frame.getContentPane().add(new Ex());
	 	frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
	 	frame.setLocationRelativeTo(null); 
	 	frame.setUndecorated(true);
	 	frame.setResizable(false);
	 	frame.setVisible(true);
	 	
	}
	
	

}