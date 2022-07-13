package autoForVariables;

import java.awt.*;
import java.awt.event.*;			//or: import java.awt.event.WindowAdapter;&import java.awt.event.WindowEvent;
public class AutoForVariables extends Frame{		//Розширяє або наслідує клас Frame
//			 subclass			 superclass
	public static void main(String[] args) {
		AutoForVariables autoFirst = new AutoForVariables("AutoPainterForVariables");
		autoFirst.setSize(500, 300);
		autoFirst.setVisible(true);
		
	}

	AutoForVariables(String title){
		super(title);
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent ev) {
				System.exit(0);
			}
		});
	}

	
	public void paint(Graphics g) {
		int wheelY, leftwheelX,rigtwheelX,wheelsize,wheelpadding, minWheelPadding, maxWheelPadding, normal=20;
		int cabinX,cabinY,cabinWidth,cabinHeight,cabinPadding;
		int bodyX,bodyY,bodyHeight,bodyWidth; 
		//*Поле ввода
		cabinY=60; cabinWidth=110; cabinHeight=40;
		
		bodyX=50; bodyWidth=250; bodyHeight=40; 
		
		wheelsize=40;
		
		//!He Поле ввода
		minWheelPadding=(wheelsize/2)*(-1);
		maxWheelPadding=((bodyWidth-((wheelsize*2)+1)))/2;
		//! -- /He Поле ввода
		
		wheelpadding=normal;
		//*-- /Поле ввода  
		
		//body
		bodyY=(cabinY+cabinHeight);
		g.drawRect(bodyX, bodyY, bodyWidth, bodyHeight);		
		cabinPadding=(bodyWidth-cabinWidth)/2;cabinX=(bodyX+cabinPadding);cabinY=(bodyY-cabinHeight);
		//cabin
		g.drawRect(cabinX, cabinY, cabinWidth, cabinHeight);		
		//wheels
		wheelY=(bodyY+bodyHeight);					
		leftwheelX=(bodyX+wheelpadding);
		rigtwheelX=(((bodyX+bodyWidth)-wheelsize)-wheelpadding);
		if(((bodyX+bodyWidth)-(wheelpadding+(wheelsize/2))) > (bodyX+bodyWidth) | (leftwheelX+wheelsize)>=rigtwheelX){
			System.out.println("Wheels error!");
		}else{
			g.drawOval(leftwheelX, wheelY, wheelsize, wheelsize);	//left wheel
			g.drawOval(rigtwheelX, wheelY, wheelsize, wheelsize);	//right wheel
		}
	}
}

