package Various;
import java.applet.*;import java.awt.*;

import javax.swing.*;


import java.awt.*;
import java.awt.event.*;

public class TimeKeeper implements Runnable {
	
	Controller Class_Controller;
	
	boolean threadSuspended;
	Thread t = null;
	//int i = 0;
	int Interval = 100;
	
	public TimeKeeper(Controller Class_Controller, int Interval) {
		//System.out.println("TimeKeeper created");
		this.Class_Controller = Class_Controller;
		this.Interval = Interval;
		
		start();
	}
	
	public void Startup() {
		//System.out.println("TimeKeeper started");
		
		start();
	}

	   public void init() {
		   
	   }

	   public void destroy() {
	   }

	   public void start() {
	      if ( t == null ) {
	         t = new Thread( this );
	         threadSuspended = false;
	         t.start();
	      } else {
	         if ( threadSuspended ) {
	            threadSuspended = false;
	            synchronized( this ) {
	               notify();
	            }
	         }
	      }
	   }

	   public void stop() {
	      threadSuspended = true;
	   }

	   public void run() {
		   
	      try {
	         while (true) {
	        	//System.out.println("++i");
	            //++i;
	            //if ( i == 10 ) {
	            //   i = 0;
	            //}
	            if ( threadSuspended ) {
	               synchronized( this ) {
	                  while ( threadSuspended ) {
	                     wait();
	                  }
	               }
	            }
	            Class_Controller.TimeTick( this );
	            t.sleep( Interval );  // interval given in milliseconds
	         }
	      } catch (InterruptedException T) { 
				System.out.println("Kunne ikke loope timer");
				System.out.println ( "Throwable message: " + T.getMessage ( ) );
				System.out.println ( "Throwable cause: " + T.getCause ( ) );
				System.out.println ( "Throwable class: " + T.getClass ( ) );
	      }
	   }

	   public void paint( Graphics g ) {

	   }
}
