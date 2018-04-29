/*<applet code="chess1.class" width=640 height=640>
</applet>*/

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

class mymessage extends Frame implements ActionListener
{
	String s;
	Button b;

	mymessage(String title,String m)
	{
	super(title);
	s=m;
	Font f=new Font("times new roman",Font.BOLD,30);
	setFont(f);
	setForeground(Color.blue);
	b=new Button("ok");
	add(b);
	b.setBounds(100,120,100,50);
	setLayout(null);
	b.addActionListener(this);
	addWindowListener(new WindowAdapter()
	{
		public void windowClosing(WindowEvent we)
		{
		setVisible(false);
		}
	}	);
}

public void paint(Graphics g)
{
	g.drawString(s,10,100);
}
public void actionPerformed(ActionEvent ae)
{
	setVisible(false);
}

};


public class chess1 extends Applet implements MouseListener,MouseMotionListener
{
Image img1,img2,img3,img4,img5,img6,img7,img8,img9,img10,img11,img12,img13,img14,img15,img16;
Image imge1,imge2,imge3,imge4,imge5,imge6,imge7,imge8,imge9,imge10,imge11,imge12,imge13,imge14,imge15,imge16;

      int i,j,x,y,c;
      boolean b;
      int pl1[]={0,80,160,240,320,400,480,560,0,80,160,240,320,400,480,560};
      int pt1[]={0,0,0,0,0,0,0,0,80,80,80,80,80,80,80,80};
      boolean le,re,lh,rh,lc,rc,k,q,p1,p2,p3,p4,p5,p6,p7,p8;
      int pl2[]={0,80,160,240,320,400,480,560,0,80,160,240,320,400,480,560};
      int pt2[]={560,560,560,560,560,560,560,560,480,480,480,480,480,480,480,480};
      boolean le1,re1,lh1,rh1,lc1,rc1,k1,q1,p11,p21,p31,p41,p51,p61,p71,p81;

      int x1,y1;
      boolean play=true,flag=false;
       mymessage m;
       boolean s6=true,s1=true,s2=true,s3=true,s4=true,s5=true,s7=true,s8=true;
       boolean s61=true,s11=true,s21=true,s31=true,s41=true,s51=true,s71=true,s81=true;
       int n;

       char role[]={'p','p','p','p','p','p','p','p','p','p','p','p','p','p','p','p'};
       boolean check=false;
       boolean c1,c2,c3,c4,c5,c6,c7,c8;

       int backl1[]=new int[16];
       int backl2[]=new int[16];
       int backt1[]=new int[16];
       int backt2[]=new int[16];


     public void init()
     {
       c=0;
       play=true;
       b=true;

       img1=getImage(getDocumentBase(),"g.jpg");
       img2=getImage(getDocumentBase(),"g1.jpg");
       img3=getImage(getDocumentBase(),"g2.jpg");
       img4=getImage(getDocumentBase(),"g3.jpg");
       img5=getImage(getDocumentBase(),"g4.jpg");
       img6=getImage(getDocumentBase(),"g2.jpg");
       img7=getImage(getDocumentBase(),"g1.jpg");
       img8=getImage(getDocumentBase(),"g.jpg");
       img9=getImage(getDocumentBase(),"g5.jpg");
       img10=getImage(getDocumentBase(),"g5.jpg");
       img11=getImage(getDocumentBase(),"g5.jpg");
       img12=getImage(getDocumentBase(),"g5.jpg");
       img13=getImage(getDocumentBase(),"g5.jpg");
       img14=getImage(getDocumentBase(),"g5.jpg");
       img15=getImage(getDocumentBase(),"g5.jpg");
       img16=getImage(getDocumentBase(),"g5.jpg");

       imge1=getImage(getDocumentBase(),"h.jpg");
       imge2=getImage(getDocumentBase(),"h1.jpg");
       imge3=getImage(getDocumentBase(),"h2.jpg");
       imge4=getImage(getDocumentBase(),"h3.jpg");
       imge5=getImage(getDocumentBase(),"h4.jpg");
       imge6=getImage(getDocumentBase(),"h2.jpg");
       imge7=getImage(getDocumentBase(),"h1.jpg");
       imge8=getImage(getDocumentBase(),"h.jpg");
       imge9=getImage(getDocumentBase(),"h5.jpg");
       imge10=getImage(getDocumentBase(),"h5.jpg");
       imge11=getImage(getDocumentBase(),"h5.jpg");
       imge12=getImage(getDocumentBase(),"h5.jpg");
       imge13=getImage(getDocumentBase(),"h5.jpg");
       imge14=getImage(getDocumentBase(),"h5.jpg");
       imge15=getImage(getDocumentBase(),"h5.jpg");
       imge16=getImage(getDocumentBase(),"h5.jpg");

       addMouseListener(this);
       addMouseMotionListener(this);
       m=new mymessage("My Chess","Player1 Round");
       m.setVisible(true);
       m.setSize(300,250);
       
     }

     public void paint(Graphics g)
       {
       for(i=0;i<640;i+=80)
       {
	       for(j=0;j<640;j+=80)
	       {
		       if(b==true)
		       {
		       g.setColor(Color.white);
		       b=false;
		       }
		       else
		       {
		       g.setColor(Color.black);
		       b=true;
		       }
		       g.drawRect(i,j,80,80);
		       g.fillRect(i,j,80,80);
	       }
	       if(b==true)
	       {
	       	b=false;
	       }
	       else
	       {
	       	b=true;
	       }
       }
        change();

       g.drawImage(img1,pl1[0]+10,pt1[0]+10,this);
       g.drawImage(img2,pl1[1]+10,pt1[1]+10,this); 
       g.drawImage(img3,pl1[2]+10,pt1[2]+10,this);
       g.drawImage(img4,pl1[3]+10,pt1[3]+10,this);
       g.drawImage(img5,pl1[4]+10,pt1[4]+10,this);
       g.drawImage(img6,pl1[5]+10,pt1[5]+10,this);
       g.drawImage(img7,pl1[6]+10,pt1[6]+10,this); 
       g.drawImage(img8,pl1[7]+10,pt1[7]+10,this);
       g.drawImage(img9,pl1[8]+10,pt1[8]+10,this);
       g.drawImage(img10,pl1[9]+10,pt1[9]+10,this); 
       g.drawImage(img11,pl1[10]+10,pt1[10]+10,this);
       g.drawImage(img12,pl1[11]+10,pt1[11]+10,this); 
       g.drawImage(img13,pl1[12]+10,pt1[12]+10,this);
       g.drawImage(img14,pl1[13]+10,pt1[13]+10,this);
       g.drawImage(img15,pl1[14]+10,pt1[14]+10,this); 
       g.drawImage(img16,pl1[15]+10,pt1[15]+10,this);

       g.drawImage(imge1,pl2[0]+10,pt2[0]+10,this);
       g.drawImage(imge2,pl2[1]+10,pt2[1]+10,this); 
       g.drawImage(imge3,pl2[2]+10,pt2[2]+10,this);
       g.drawImage(imge4,pl2[3]+10,pt2[3]+10,this);
       g.drawImage(imge5,pl2[4]+10,pt2[4]+10,this);
       g.drawImage(imge6,pl2[5]+10,pt2[5]+10,this);
       g.drawImage(imge7,pl2[6]+10,pt2[6]+10,this); 
       g.drawImage(imge8,pl2[7]+10,pt2[7]+10,this);
       g.drawImage(imge9,pl2[8]+10,pt2[8]+10,this);
       g.drawImage(imge10,pl2[9]+10,pt2[9]+10,this); 
       g.drawImage(imge11,pl2[10]+10,pt2[10]+10,this);
       g.drawImage(imge12,pl2[11]+10,pt2[11]+10,this); 
       g.drawImage(imge13,pl2[12]+10,pt2[12]+10,this);
       g.drawImage(imge14,pl2[13]+10,pt2[13]+10,this);
       g.drawImage(imge15,pl2[14]+10,pt2[14]+10,this); 
       g.drawImage(imge16,pl2[15]+10,pt2[15]+10,this);

      
       } 
      public void mouseEntered(MouseEvent me)
      {
      }
      public void mouseExited(MouseEvent me)
      {
      }
      public void mousePressed(MouseEvent me)
      {
      }
      public void mouseReleased(MouseEvent me)
      {
      }
      public void mouseClicked(MouseEvent me)
      {
       backup();
      if(play==true)
      {
        flag=false;
        x1=Math.round(x/80)*80;
        y1=Math.round(y/80)*80;
		c++;
        
		
        if(c==1)
        {
				if(pl1[0]==x1 && pt1[0]==y1)
				{
				le=true;
                re=false;
                lh=false;
                rh=false;
                lc=false;
                rc=false;
                k=false;
                q=false;
                p1=false;
                p2=false;
                p3=false;
                p4=false;
                p5=false;
                p6=false;
                p7=false;
                p8=false;
                }
                else if(pl1[1]==x1 && pt1[1]==y1)
                {
                le=false;
                re=false;
                lh=true;
                rh=false;
                lc=false;
                rc=false;
                k=false;
                q=false;
                p1=false;
                p2=false;
                p3=false;
                p4=false;
                p5=false;
                p6=false;
                p7=false;
                p8=false;

                }
                else if(pl1[2]==x1 && pt1[2]==y1)
                {
                le=false;
                re=false;
                lh=false;
                rh=false;
                lc=true;
                rc=false;
                k=false;
                q=false;
                p1=false;
                p2=false;
                p3=false;
                p4=false;
                p5=false;
                p6=false;
                p7=false;
                p8=false;

                }
                else if(pl1[3]==x1 && pt1[3]==y1)
                {
                le=false;
                re=false;
                lh=false;
                rh=false;
                lc=false;
                rc=false;
                k=false;
                q=true;
                p1=false;
                p2=false;
                p3=false;
                p4=false;
                p5=false;
                p6=false;
                p7=false;
                p8=false;

                }

                else if(pl1[4]==x1 && pt1[4]==y1)
                {
                le=false;
                re=false;
                lh=false;
                rh=false;
                lc=false;
                rc=false;
                k=true;
                q=false;
                p1=false;
                p2=false;
                p3=false;
                p4=false;
                p5=false;
                p6=false;
                p7=false;
                p8=false;

                }
                else if(pl1[5]==x1 && pt1[5]==y1)
                {
                le=false;
                re=false;
                lh=false;
                rh=false;
                lc=false;
                rc=true;
                k=false;
                q=false;
                p1=false;
                p2=false;
                p3=false;
                p4=false;
                p5=false;
                p6=false;
                p7=false;
                p8=false;

                }
                else if(pl1[6]==x1 && pt1[6]==y1)
                {
                le=false;
                re=false;
                lh=false;
                rh=true;
                lc=false;
                rc=false;
                k=false;
                q=false;
                p1=false;
                p2=false;
                p3=false;
                p4=false;
                p5=false;
                p6=false;
                p7=false;
                p8=false;

                }
                else if(pl1[7]==x1 && pt1[7]==y1)
                {
                le=false;
                re=true;
                lh=false;
                rh=false;
                lc=false;
                rc=false;
                k=false;
                q=false;
                p1=false;
                p2=false;
                p3=false;
                p4=false;
                p5=false;
                p6=false;
                p7=false;
                p8=false;

                }
                else if(pl1[8]==x1 && pt1[8]==y1)
                {
                le=false;
                re=false;
                lh=false;
                rh=false;
                lc=false;
                rc=false;
                k=false;
                q=false;
                p1=true;
                p2=false;
                p3=false;
                p4=false;
                p5=false;
                p6=false;
                p7=false;
                p8=false;

                }
                else if(pl1[9]==x1 && pt1[9]==y1)
                {
                le=false;
                re=false;
                lh=false;
                rh=false;
                lc=false;
                rc=false;
                k=false;
                q=false;
                p1=false;
                p2=true;
                p3=false;
                p4=false;
                p5=false;
                p6=false;
                p7=false;
                p8=false;

                }

                else if(pl1[10]==x1 && pt1[10]==y1)
                {
                le=false;
                re=false;
                lh=false;
                rh=false;
                lc=false;
                rc=false;
                k=false;
                q=false;
                p1=false;
                p2=false;
                p3=true;
                p4=false;
                p5=false;
                p6=false;
                p7=false;
                p8=false;

                }

                else if(pl1[11]==x1 && pt1[11]==y1)
                {
                le=false;
                re=false;
                lh=false;
                rh=false;
                lc=false;
                rc=false;
                k=false;
                q=false;
                p1=false;
                p2=false;
                p3=false;
                p4=true;
                p5=false;
                p6=false;
                p7=false;
                p8=false;

                }

                else if(pl1[12]==x1 && pt1[12]==y1)
                {
                le=false;
                re=false;
                lh=false;
                rh=false;
                lc=false;
                rc=false;
                k=false;
                q=false;
                p1=false;
                p2=false;
                p3=false;
                p4=false;
                p5=true;
                p6=false;
                p7=false;
                p8=false;

                }

                else if(pl1[13]==x1 && pt1[13]==y1)
                {
                le=false;
                re=false;
                lh=false;
                rh=false;
                lc=false;
                rc=false;
                k=false;
                q=false;
                p1=false;
                p2=false;
                p3=false;
                p4=false;
                p5=false;
                p6=true;
                p7=false;
                p8=false;

                }

                else if(pl1[14]==x1 && pt1[14]==y1)
                {
                le=false;
                re=false;
                lh=false;
                rh=false;
                lc=false;
                rc=false;
                k=false;
                q=false;
                p1=false;
                p2=false;
                p3=false;
                p4=false;
                p5=false;
                p6=false;
                p7=true;
                p8=false;

                }

                else if(pl1[15]==x1 && pt1[15]==y1)
                {
                le=false;
                re=false;
                lh=false;
                rh=false;
                lc=false;
                rc=false;
                k=false;
                q=false;
                p1=false;
                p2=false;
                p3=false;
                p4=false;
                p5=false;
                p6=false;
                p7=false;
                p8=true;
		}

                else
                {       c=0;            }
                
        }

        else if(c==2)
        {
                if(le==true)
                {
                        elephant1(0);
                }
                else if(lh==true)
                {
                        hourse1(1);
                }
                else if(lc==true)
                {
                        camal1(2);
                }
                else if(q==true)
                {
                        queen1(3);
                }

                else if(k==true)
                {
                        king1(4);
                }
                else if(rc==true)
                {
                        camal1(5);
                }

                else if(rh==true)
                {
                        hourse1(6);
                }
                else if(re==true)
                {
                        elephant1(7);
                }

                else if(p1==true)
                {
                        switch(role[0])
                        {
                        case 'p':
                        s1=piyada1(8,s1);
                        break;

                        case 'e':
                        elephant1(8);
                        break;

                        case 'h':
                        hourse1(8);
                        break;

                        case 'c':
                        camal1(8);
                        break;

                        case 'k':
                        king1(8);
                        break;

                        case 'q':
                        queen1(8);
                        break;
                        }
                        
                }
                else if(p2==true)
                {
                        switch(role[1])
                        {
                        case 'p':
                        s2=piyada1(9,s2);
                        break;

                        case 'e':
                        elephant1(9);
                        break;

                        case 'h':
                        hourse1(9);
                        break;

                        case 'c':
                        camal1(9);
                        break;

                        case 'k':
                        king1(9);
                        break;

                        case 'q':
                        queen1(9);
                        break;
                        }
                        
                       
                }


                else if(p3==true)
                {
                        switch(role[2])
                        {
                        case 'p':
                        s3=piyada1(10,s3);
                        break;

                        case 'e':
                        elephant1(10);
                        break;

                        case 'h':
                        hourse1(10);
                        break;

                        case 'c':
                        camal1(10);
                        break;

                        case 'k':
                        king1(10);
                        break;

                        case 'q':
                        queen1(10);
                        break;
                        }
                        
                }


                else if(p4==true)
                {
                        switch(role[3])
                        {
                        case 'p':
                        s4=piyada1(11,s4);
                        break;

                        case 'e':
                        elephant1(11);
                        break;

                        case 'h':
                        hourse1(11);
                        break;

                        case 'c':
                        camal1(11);
                        break;

                        case 'k':
                        king1(11);
                        break;

                        case 'q':
                        queen1(11);
                        break;
                        }
                        
                        
                }

                
                else if(p5==true)
                {
                        switch(role[4])
                        {
                        case 'p':
                        s5=piyada1(12,s5);
                        break;

                        case 'e':
                        elephant1(12);
                        break;

                        case 'h':
                        hourse1(12);
                        break;

                        case 'c':
                        camal1(12);
                        break;

                        case 'k':
                        king1(12);
                        break;

                        case 'q':
                        queen1(12);
                        break;
                        }
                        
                       
                }


                else if(p6==true)
                {
                        switch(role[5])
                        {
                        case 'p':
                        s6=piyada1(13,s6);
                        break;

                        case 'e':
                        elephant1(13);
                        break;

                        case 'h':
                        hourse1(13);
                        break;

                        case 'c':
                        camal1(13);
                        break;

                        case 'k':
                        king1(13);
                        break;

                        case 'q':
                        queen1(13);
                        break;
                        }
                        
                        
                }


                else if(p7==true)
                {
                        switch(role[6])
                        {
                        case 'p':
                        s7=piyada1(14,s7);
                        break;

                        case 'e':
                        elephant1(14);
                        break;

                        case 'h':
                        hourse1(14);
                        break;

                        case 'c':
                        camal1(14);
                        break;

                        case 'k':
                        king1(14);
                        break;

                        case 'q':
                        queen1(14);
                        break;
                        }
                        
                         
                }


                else if(p8==true)
                {
                        switch(role[7])
                        {
                        case 'p':
                        s8=piyada1(15,s8);
                        break;

                        case 'e':
                        elephant1(15);
                        break;

                        case 'h':
                        hourse1(15);
                        break;

                        case 'c':
                        camal1(15);
                        break;

                        case 'k':
                        king1(15);
                        break;

                        case 'q':
                        queen1(15);
                        break;
                        }
                        
                        
                }



        }
        else
        {
        c=0;
        }
      
       }
		//player 2
       else
       {
        flag=false;
        x1=Math.round(x/80)*80;
        y1=Math.round(y/80)*80;
        c++;
        if(c==1)
        {
                if(pl2[0]==x1 && pt2[0]==y1)
                {
                le1=true;
                re1=false;
                lh1=false;
                rh1=false;
                lc1=false;
                rc1=false;
                k1=false;
                q1=false;
                p11=false;
                p21=false;
                p31=false;
                p41=false;
                p51=false;
                p61=false;
                p71=false;
                p81=false;
                }
                else if(pl2[1]==x1 && pt2[1]==y1)
                {
                le1=false;
                re1=false;
                lh1=true;
                rh1=false;
                lc1=false;
                rc1=false;
                k1=false;
                q1=false;
                p11=false;
                p21=false;
                p31=false;
                p41=false;
                p51=false;
                p61=false;
                p71=false;
                p81=false;

                }
                else if(pl2[2]==x1 && pt2[2]==y1)
                {
                le1=false;
                re1=false;
                lh1=false;
                rh1=false;
                lc1=true;
                rc1=false;
                k1=false;
                q1=false;
                p11=false;
                p21=false;
                p31=false;
                p41=false;
                p51=false;
                p61=false;
                p71=false;
                p81=false;

                }
                else if(pl2[3]==x1 && pt2[3]==y1)
                {
                le1=false;
                re1=false;
                lh1=false;
                rh1=false;
                lc1=false;
                rc1=false;
                k1=false;
                q1=true;
                p11=false;
                p21=false;
                p31=false;
                p41=false;
                p51=false;
                p61=false;
                p71=false;
                p81=false;

                }

                else if(pl2[4]==x1 && pt2[4]==y1)
                {
                le1=false;
                re1=false;
                lh1=false;
                rh1=false;
                lc1=false;
                rc1=false;
                k1=true;
                q1=false;
                p11=false;
                p21=false;
                p31=false;
                p41=false;
                p51=false;
                p61=false;
                p71=false;
                p81=false;

                }
                else if(pl2[5]==x1 && pt2[5]==y1)
                {
                le1=false;
                re1=false;
                lh1=false;
                rh1=false;
                lc1=false;
                rc1=true;
                k1=false;
                q1=false;
                p11=false;
                p21=false;
                p31=false;
                p41=false;
                p51=false;
                p61=false;
                p71=false;
                p81=false;

                }
                else if(pl2[6]==x1 && pt2[6]==y1)
                {
                le1=false;
                re1=false;
                lh1=false;
                rh1=true;
                lc1=false;
                rc1=false;
                k1=false;
                q1=false;
                p11=false;
                p21=false;
                p31=false;
                p41=false;
                p51=false;
                p61=false;
                p71=false;
                p81=false;

                }
                else if(pl2[7]==x1 && pt2[7]==y1)
                {
                le1=false;
                re1=true;
                lh1=false;
                rh1=false;
                lc1=false;
                rc1=false;
                k1=false;
                q1=false;
                p11=false;
                p21=false;
                p31=false;
                p41=false;
                p51=false;
                p61=false;
                p71=false;
                p81=false;

                }
                else if(pl2[8]==x1 && pt2[8]==y1)
                {
                le1=false;
                re1=false;
                lh1=false;
                rh1=false;
                lc1=false;
                rc1=false;
                k1=false;
                q1=false;
                p11=true;
                p21=false;
                p31=false;
                p41=false;
                p51=false;
                p61=false;
                p71=false;
                p81=false;

                }
                else if(pl2[9]==x1 && pt2[9]==y1)
                {
                le1=false;
                re1=false;
                lh1=false;
                rh1=false;
                lc1=false;
                rc1=false;
                k1=false;
                q1=false;
                p11=false;
                p21=true;
                p31=false;
                p41=false;
                p51=false;
                p61=false;
                p71=false;
                p81=false;

                }

                else if(pl2[10]==x1 && pt2[10]==y1)
                {
                le1=false;
                re1=false;
                lh1=false;
                rh1=false;
                lc1=false;
                rc1=false;
                k1=false;
                q1=false;
                p11=false;
                p21=false;
                p31=true;
                p41=false;
                p51=false;
                p61=false;
                p71=false;
                p81=false;

                }

                else if(pl2[11]==x1 && pt2[11]==y1)
                {
                le1=false;
                re1=false;
                lh1=false;
                rh1=false;
                lc1=false;
                rc1=false;
                k1=false;
                q1=false;
                p11=false;
                p21=false;
                p31=false;
                p41=true;
                p51=false;
                p61=false;
                p71=false;
                p81=false;

                }

                else if(pl2[12]==x1 && pt2[12]==y1)
                {
                le1=false;
                re1=false;
                lh1=false;
                rh1=false;
                lc1=false;
                rc1=false;
                k1=false;
                q1=false;
                p11=false;
                p21=false;
                p31=false;
                p41=false;
                p51=true;
                p61=false;
                p71=false;
                p81=false;

                }

                else if(pl2[13]==x1 && pt2[13]==y1)
                {
                le1=false;
                re1=false;
                lh1=false;
                rh1=false;
                lc1=false;
                rc1=false;
                k1=false;
                q1=false;
                p11=false;
                p21=false;
                p31=false;
                p41=false;
                p51=false;
                p61=true;
                p71=false;
                p81=false;

                }

                else if(pl2[14]==x1 && pt2[14]==y1)
                {
                le1=false;
                re1=false;
                lh1=false;
                rh1=false;
                lc1=false;
                rc1=false;
                k1=false;
                q1=false;
                p11=false;
                p21=false;
                p31=false;
                p41=false;
                p51=false;
                p61=false;
                p71=true;
                p81=false;

                }

                else if(pl2[15]==x1 && pt2[15]==y1)
                {
                le1=false;
                re1=false;
                lh1=false;
                rh1=false;
                lc1=false;
                rc1=false;
                k1=false;
                q1=false;
                p11=false;
                p21=false;
                p31=false;
                p41=false;
                p51=false;
                p61=false;
                p71=false;
                p81=true;

                }
                else
                {
                c=0;
                }
            
        }
        else if(c==2)
        {
                if(le1==true)
                {
                        elephant2(0);
                }
                else if(lh1==true)
                {
                        hourse2(1);
                }
                else if(lc1==true)
                {
                        camal2(2);
                }
                else if(q1==true)
                {
                        queen2(3);
                }

                else if(k1==true)
                {
                        king2(4);
                }
                else if(rc1==true)
                {
                        camal2(5);
                }

                else if(rh1==true)
                {
                        hourse2(6);
                }
                else if(re1==true)
                {
                        elephant2(7);
                }


                else if(p11==true)
                {
                        switch(role[8])
                        {
                        case 'p':
                        s11=piyada2(8,s11);
                        break;

                        case 'e':
                        elephant2(8);
                        break;

                        case 'h':
                        hourse2(8);
                        break;

                        case 'c':
                        camal2(8);
                        break;

                        case 'k':
                        king2(8);
                        break;

                        case 'q':
                        queen2(8);
                        break;
                        }
                        
                        
                }
                else if(p21==true)
                {
                        switch(role[9])
                        {
                        case 'p':
                        s21=piyada2(9,s21);
                        break;

                        case 'e':
                        elephant2(9);
                        break;

                        case 'h':
                        hourse2(9);
                        break;

                        case 'c':
                        camal2(9);
                        break;

                        case 'k':
                        king2(9);
                        break;

                        case 'q':
                        queen2(9);
                        break;
                        }
                       
                }

                else if(p31==true)
                {
                        switch(role[10])
                        {
                        case 'p':
                        s31=piyada2(10,s31);
                        break;

                        case 'e':
                        elephant2(10);
                        break;

                        case 'h':
                        hourse2(10);
                        break;

                        case 'c':
                        camal2(10);
                        break;

                        case 'k':
                        king2(10);
                        break;

                        case 'q':
                        queen2(10);
                        break;
                        }
                       
                }


                else if(p41==true)
                {
                        switch(role[11])
                        {
                        case 'p':
                        s41=piyada2(11,s41);
                        break;

                        case 'e':
                        elephant2(11);
                        break;

                        case 'h':
                        hourse2(11);
                        break;

                        case 'c':
                        camal2(11);
                        break;

                        case 'k':
                        king2(11);
                        break;

                        case 'q':
                        queen2(11);
                        break;
                        }
                    
                }

                
                else if(p51==true)
                {
                        switch(role[12])
                        {
                        case 'p':
                        s51=piyada2(12,s51);
                        break;

                        case 'e':
                        elephant2(12);
                        break;

                        case 'h':
                        hourse2(12);
                        break;

                        case 'c':
                        camal2(12);
                        break;

                        case 'k':
                        king2(12);
                        break;

                        case 'q':
                        queen2(12);
                        break;
                        }
                        
                }


                else if(p61==true)
                {
                        switch(role[13])
                        {
                        case 'p':
                        s61=piyada2(13,s61);
                        break;

                        case 'e':
                        elephant2(13);
                        break;

                        case 'h':
                        hourse2(13);
                        break;

                        case 'c':
                        camal2(13);
                        break;

                        case 'k':
                        king2(13);
                        break;

                        case 'q':
                        queen2(13);
                        break;
                        }
                      
                }


                else if(p71==true)
                {
                        switch(role[14])
                        {
                        case 'p':
                        s71=piyada2(14,s71);
                        break;

                        case 'e':
                        elephant2(14);
                        break;

                        case 'h':
                        hourse2(14);
                        break;

                        case 'c':
                        camal2(14);
                        break;

                        case 'k':
                        king2(14);
                        break;

                        case 'q':
                        queen2(14);
                        break;
                        }
                       
                }


                else if(p81==true)
                {
                        switch(role[15])
                        {
                        case 'p':
                        s51=piyada2(15,s81);
                        break;

                        case 'e':
                        elephant2(15);
                        break;

                        case 'h':
                        hourse2(15);
                        break;

                        case 'c':
                        camal2(15);
                        break;

                        case 'k':
                        king2(15);
                        break;

                        case 'q':
                        queen2(15);
                        break;
                        }                         
                }          
        }
        else
        {        c=0;        }

       }
      }

      public void mouseMoved(MouseEvent me)
      {
         x=me.getX();
         y=me.getY();
         showStatus("mouse at (" + x + "," + y + ")");

      }

      public void mouseDragged(MouseEvent me)
      {
      }

      void elephant1(int z)
      {
                        if(pl1[z]==x1 || pt1[z]==y1)
                        {
                        if(pl1[z]==x1 && pt1[z]<y1)
                        {
                           for(i=pt1[z]+80;i<=y1;i+=80)
                           {
                                for(j=0;j<=15;j++)
                                {
                                        if(pl1[j]==x1 && pt1[j]==i)
                                        {
                                         flag=true;
                                         break;
                                        }
                                        else
                                        {
                                          flag=false;
                                        }
                                }
                                if(flag==true)
                                {
                                break;
                                }
                                
                           }
                           if(flag==true)
                           {    wrongselection();         }
                           else
                           {
                                         for(j=0;j<=15;j++)
                                         {
                                                if(x1==pl2[j] && y1==pt2[j])
                                                {
                                                pl2[j]=-200;
                                                pt2[j]=-200;
                                                }
                                         }


                                          pl1[z]=x1;
                                          pt1[z]=y1;
                                          repaint();
                                          c=0;
                                          if(mate2()==true)
                                          {wrongselectcheck();}
                                          else
                                          {

                                          if(play==true)
                                           {
                                         m=new mymessage("my chess","Player2's Round");
                                         play=false;
                                           }
                                          else
                                            {
                                          m=new mymessage("my chess","Player1's Round");
                                          play=true;
                                            }
                                         m.setVisible(true);
                                         m.setSize(300,250);
                                         }

                           }
                        }
                        else if(pl1[z]==x1 && pt1[z]>y1)
                        {
                           for(i=y1;i<pt1[z];i+=80)
                           {
                                for(j=0;j<=15;j++)
                                {
                                        if(pl1[j]==x1 && pt1[j]==i)
                                        {
                                        flag=true;
                                         break;
                                        }
                                        else
                                        {
                                        flag=false;
                                        }

                                }
                                if(flag==true)
                                {
                                break;
                                }
                           }
                           if(flag==true)
                           {            wrongselection();      }

                           else
                           {
                                         for(j=0;j<=15;j++)
                                         {
                                                if(x1==pl2[j] && y1==pt2[j])
                                                {
                                                pl2[j]=-200;
                                                pt2[j]=-200;
                                                }
                                         }
                                           
                                          pl1[z]=x1;
                                          pt1[z]=y1;
                                          repaint();
                                          
                                          c=0;
                                          if(mate2()==true)
                                          {wrongselectcheck();}
                                          else
                                          {

                                          if(play==true)
                                           {
                                         m=new mymessage("my chess","Player2's Round");
                                         play=false;
                                           }
                                          else
                                            {
                                          m=new mymessage("my chess","Player1's Round");
                                          play=true;
                                            }
                                         m.setVisible(true);
                                         m.setSize(300,250);
                                         }
                           }


                        }
                        else if(pt1[z]==y1 && pl1[z]<x1)
                        {
                           for(i=pl1[z]+80;i<=x1;i+=80)
                           {
                                for(j=0;j<=15;j++)
                                {
                                        if(pt1[j]==y1 && pl1[j]==i)
                                        {
                                       flag=true;
                                         break;
                                        }
                                        else
                                        {
                                       flag=false;
                                        }

                                }
                                if(flag==true)
                                {
                                break;
                                }
                           }
                           if(flag==true)                                        
                           {      wrongselection();        }

                           else
                           {
                                         for(j=0;j<=15;j++)
                                         {
                                                if(x1==pl2[j] && y1==pt2[j])
                                                {
                                                pl2[j]=-200;
                                                pt2[j]=-200;
                                                }
                                         }

                                           
                                          pl1[z]=x1;
                                          pt1[z]=y1;
                                         
                                          repaint();
                                          c=0;
                                          if(mate2()==true)
                                          {
                                                 undo();
                                                 repaint();
                                              m=new mymessage("","wrong selection,check ccurs");
                                                 m.setVisible(true);
                                                 m.setSize(300,250);
                                                 
                                          }
                                          else
                                          {

                                          	if(play==true)
                                           	{
                                         	m=new mymessage("my chess","Player2's Round");
                                        	 play=false;
                                           	}
                                          	else
                                            	{
                                          	m=new mymessage("my chess","Player1's Round");
                                         	 play=true;
                                            	}
                                         	m.setVisible(true);
                                         	m.setSize(300,250);
                                         }

                           }

                        }
                        else if(pt1[z]==y1 && pl1[z]>x1)
                        {
                           for(i=x1;i<pl1[z];i+=80)
                           {
                                for(j=0;j<=15;j++)
                                {
                                        if(pt1[j]==y1 && pl1[j]==i)
                                        {
                                        flag=true;
                                        break;
                                        }
                                        else
                                        {
                                        flag=false;
                                        }

                                }
                                if(flag==true)
                                {
                                break;
                                }
                           }
                           if(flag==true)
                           {             wrongselection();    }

                           else
                           {
                                         for(j=0;j<=15;j++)
                                         {
                                                if(x1==pl2[j] && y1==pt2[j])
                                                {
                                                pl2[j]=-200;
                                                pt2[j]=-200;
                                                }
                                         }
                                           
                                          pl1[z]=x1;
                                          pt1[z]=y1;
                                          repaint();
                                          c=0;
                                          if(mate2()==true)
                                          {wrongselectcheck();}
                                          else
                                          {

                                          	if(play==true)
                                           	{
	                                         m=new mymessage("my chess","Player2's Round");
	                                         play=false;
        	                                   }
                	                        else
                        	                {
                               	                 m=new mymessage("my chess","Player1's Round");	
  	                                          play=true;
        	                                }
                	                         m.setVisible(true);
                        	                 m.setSize(300,250);
                                         }
                                      }
                        }              
                     }

                        else
                        {      wrongselection();           }

                        if(mate1())
                        {wrongcheck();	}
                        

      }
      void hourse1(int z)
      {
                        if((pl1[z]+80==x1 && pt1[z]+160==y1) || (pl1[z]-80==x1 && pt1[z]+160==y1) || (pl1[z]+80==x1 && pt1[z]-160==y1) || (pl1[z]-80==x1 && pt1[z]-160==y1) || (pl1[z]+160==x1 && pt1[z]+80==y1) || (pl1[z]+160==x1 && pt1[z]-80==y1) || (pl1[z]-160==x1 && pt1[z]+80==y1) || (pl1[z]-160==x1 && pt1[z]-80==y1) )
                        {
                                for(j=0;j<=15;j++)
                                {
                                        if(x1==pl1[j] && y1==pt1[j])
                                        {
                                        flag=true;
                                        break;
                                        }
                                        else
                                        {
                                        flag=false;
                                        }
                                }


                           if(flag==true)
                           {          wrongselection();   }

                           else
                           {
                                         for(j=0;j<=15;j++)
                                         {
                                                if(x1==pl2[j] && y1==pt2[j])
                                                {
                                                pl2[j]=-200;
                                                pt2[j]=-200;
                                                }
                                         }
                                        
                                          pl1[z]=x1;
                                          pt1[z]=y1;
                                          repaint();
                                          c=0;
                                          if(mate2()==true)
                                          {wrongselectcheck(); }
                                          else
                                          {

                                          	if(play==true)
	                                           {
         	                                m=new mymessage("my chess","Player2's Round");
                	                         play=false;
                        	                   }
                                	         else
                                        	 {
        	                                 m=new mymessage("my chess","Player1's round");
	                                          play=true;
                                            	 }
                                         m.setVisible(true);
                                         m.setSize(300,250);
                                         }

                           }
                        }
                        else
                        {  wrongselection();    }

                        if(mate1())
                        {wrongcheck();	}
                   
      }

      void camal1(int z)
      {
                        if(Math.abs(Math.abs(pl1[z])-Math.abs(x1))==Math.abs(Math.abs(pt1[z])-Math.abs(y1)))
                        {
                                if(x1<pl1[z] && y1<pt1[z])
                                {
                                   for(i=x1,j=y1;i<pl1[z];i+=80,j+=80)
                                   {
                                        for(n=0;n<=15;n++)
                                        {
                                                if(i==pl1[n] && j==pt1[n])
                                                {
                                                        flag=true;
                                                        break;
                                                }
                                                else
                                                {
                                                        flag=false;
                                                }
                                        }
                                        if(flag==true)
                                        {
                                        break;
                                        }
                                   }
                           if(flag==true)
                           {            wrongselection();       }

                           else
                           {
                                         for(j=0;j<=15;j++)
                                         {
                                                if(x1==pl2[j] && y1==pt2[j])
                                                {
                                                pl2[j]=-200;
                                                pt2[j]=-200;
                                                }
                                         }
                                          
                                          pl1[z]=x1;
                                          pt1[z]=y1;
                                          repaint();
                                          c=0;
                                          if(mate2()==true)
                                          {wrongselectcheck();}
                                          else
                                          {

                                          if(play==true)
                                           {
                                         m=new mymessage("my chess","Player2's Round");
                                         play=false;
                                           }
                                          else
                                            {
                                          m=new mymessage("my chess","Player1's Round");
                                          play=true;
                                            }
                                         m.setVisible(true);
                                         m.setSize(300,250);
                                         }

                           }
                                  
                         }
                          else if(x1>pl1[z] && y1>pt1[z])
                          {
                                   for(i=pl1[z]+80,j=pt1[z]+80;i<=x1;i+=80,j+=80)
                                   {
                                        for(n=0;n<=15;n++)
                                        {
                                                if(i==pl1[n] && j==pt1[n])
                                                {
                                                        flag=true;
                                                        break;
                                                }
                                                else
                                                {
                                                        flag=false;
                                                }
                                        }
                                        if(flag==true)
                                        {
                                        break;
                                        }
                                   }
                           if(flag==true)
                           {	wrongselection();    }

                           else
                           {
                                         for(j=0;j<=15;j++)
                                         {
                                                if(x1==pl2[j] && y1==pt2[j])
                                                {
                                                pl2[j]=-200;
                                                pt2[j]=-200;
                                                }
                                         }
                                        
                                          pl1[z]=x1;
                                          pt1[z]=y1;
                                          repaint();
                                          c=0;
                                          if(mate2()==true)
                                          {wrongselectcheck();}
                                          else
                                          {

                                          if(play==true)
                                           {
                                         m=new mymessage("my chess","Player2's Round");
                                         play=false;
                                           }
                                          else
                                            {
                                          m=new mymessage("my chess","Player1's Round");
                                          play=true;
                                            }
                                         m.setVisible(true);
                                         m.setSize(300,250);
                                         }

                           }
                                
                          }
                          else if(x1>pl1[z] && y1< pt1[z])
                          {
                                   for(i=pl1[z]+80,j=pt1[z]-80;i<=x1;i+=80,j-=80)
                                   {
                                        for(n=0;n<=15;n++)
                                        {
                                                if(i==pl1[n] && j==pt1[n])
                                                {
                                                        flag=true;
                                                        break;
                                                }
                                                else
                                                {
                                                        flag=false;
                                                }
                                        }
                                        if(flag==true)
                                        {
                                        break;
                                        }
                                   }
                           if(flag==true)
                           {wrongselection();    }

                           else
                           {
                                         for(j=0;j<=15;j++)
                                         {
                                                if(x1==pl2[j] && y1==pt2[j])
                                                {
                                                pl2[j]=-200;
                                                pt2[j]=-200;
                                                }
                                         }
                                        
                                          pl1[z]=x1;
                                          pt1[z]=y1;
                                          repaint();
                                          c=0;
                                          if(mate2()==true)
                                          {wrongselectcheck(); }
                                          else
                                          {

                                          if(play==true)
                                           {
                                         m=new mymessage("my chess","Player2's Round");
                                         play=false;
                                           }
                                          else
                                            {
                                          m=new mymessage("my chess","Player1's Round");
                                          play=true;
                                            }
                                         m.setVisible(true);
                                         m.setSize(300,250);
                                         }

                           }
                                
                          }
                          else if(x1<pl1[z] && y1>pt1[z])
                          {
                                   for(i=x1,j=y1;i<pl1[z];i+=80,j-=80)
                                   {
                                        for(n=0;n<=15;n++)
                                        {
                                                if(i==pl1[n] && j==pt1[n])
                                                {
                                                        flag=true;
                                                        break;
                                                }
                                                else
                                                {
                                                        flag=false;
                                                }
                                        }
                                        if(flag==true)
                                        {
                                        break;
                                        }
                                   }
                           if(flag==true)
                           {         wrongselection();              }

                           else
                           {
                                         for(j=0;j<=15;j++)
                                         {
                                                if(x1==pl2[j] && y1==pt2[j])
                                                {
                                                pl2[j]=-200;
                                                pt2[j]=-200;
                                                }
                                         }
                                        
                                          pl1[z]=x1;
                                          pt1[z]=y1;
                                          repaint();
                                          c=0;
                                          if(mate2()==true)
                                          {wrongselectcheck(); }
                                          else
                                          {

                                          if(play==true)
                                           {
                                         m=new mymessage("my chess","Player2's Round");
                                         play=false;
                                           }
                                          else
                                            {
                                          m=new mymessage("my chess","Player1's Round");
                                          play=true;
                                            }
                                         m.setVisible(true);
                                         m.setSize(300,250);
                                         }
                           }
                                
                          }
                        }
                        else
                        {wrongselection();    }

                        if(mate1())
                        {wrongcheck();	}
         
                
      }


      void king1(int z)
      {
                if(((pl2[z]+80==x1 && pt2[z]==y1) || (pt2[z]+80==y1 && pl2[z]==x1) || (pl2[z]-80==x1 && pt2[z]==y1) || (pt2[z]-80==y1 && pl2[z]==x1) || (pl2[z]-80==x1&& pt2[z]-80==y1) || (pl2[z]+80==x1&& pt2[z]+80==y1)|| (pl2[z]-80==x1 && pt2[z]+80==y1)|| (pl2[z]+80==x1 && pt2[z]-80==y1)))
                {	wrongselection();     }

                else if(((pl1[z]+80==x1 && pt1[z]==y1) || (pt1[z]+80==y1 && pl1[z]==x1) || (pl1[z]-80==x1 && pt1[z]==y1) || (pt1[z]-80==y1 && pl1[z]==x1) || (pl1[z]-80==x1&& pt1[z]-80==y1) || (pl1[z]+80==x1&& pt1[z]+80==y1)|| (pl1[z]-80==x1 && pt1[z]+80==y1)|| (pl1[z]+80==x1 && pt1[z]-80==y1)))
                        {
                                for(j=0;j<=15;j++)
                                {
                                        if(x1==pl1[j] && y1==pt1[j])
                                        {
                                        flag=true;
                                        break;
                                        }
                                        else
                                        {
                                        flag=false;
                                        }
                                }


                           if(flag==true)
                           {	wrongselection();     }

                           else
                           {
                                         for(j=0;j<=15;j++)
                                         {
                                                if(x1==pl2[j] && y1==pt2[j])
                                                {
                                                pl2[j]=-200;
                                                pt2[j]=-200;
                                                }
                                         }
                                        
                                          pl1[z]=x1;
                                          pt1[z]=y1;
                                          repaint();
                                          c=0;
                                          if(mate2()==true)
                                          {wrongselectcheck(); }
                                          else
                                          {

                                          if(play==true)
                                           {
                                         m=new mymessage("my chess","Player2's Round");
                                         play=false;
                                           }
                                          else
                                            {
                                          m=new mymessage("my chess","Player1's Round");
                                          play=true;
                                            }
                                         m.setVisible(true);
                                         m.setSize(300,250);
                                         }

                           }
                        }
                        else
                        {	wrongselection();     }

                        if(mate1())
                        {wrongcheck();	}
         
      }

      void queen1(int z)
      {

                        if(pl1[z]==x1 || pt1[z]==y1 ||Math.abs(Math.abs(pl1[z])-Math.abs(x1))==Math.abs(Math.abs(pt1[z])-Math.abs(y1)))
                        {
                        if(pl1[z]==x1 && pt1[z]<y1)
                        {
                           for(i=pt1[z]+80;i<=y1;i+=80)
                           {
                                for(j=0;j<=15;j++)
                                {
                                        if(pl1[j]==x1 && pt1[j]==i)
                                        {
                                         flag=true;
                                         break;
                                        }
                                        else
                                        {
                                          flag=false;
                                        }
                                }
                                if(flag==true)
                                {
                                break;
                                }
                                
                           }
                           if(flag==true)
                           {      wrongselection();    }

                           else
                           {
                                         for(j=0;j<=15;j++)
                                         {
                                                if(x1==pl2[j] && y1==pt2[j])
                                                {
                                                pl2[j]=-200;
                                                pt2[j]=-200;
                                                }
                                         }
                                        
                                          pl1[z]=x1;
                                          pt1[z]=y1;
                                          repaint();
                                          c=0;
                                          if(mate2()==true)
                                          {wrongselectcheck();}
                                          else
                                          {

                                          if(play==true)
                                           {
                                         m=new mymessage("my chess","Player2's Round");
                                         play=false;
                                           }
                                          else
                                            {
                                          m=new mymessage("my chess","Player1's Round");
                                          play=true;
                                            }
                                         m.setVisible(true);
                                         m.setSize(300,250);
                                         }

                           }
                        }
                        else if(pl1[z]==x1 && pt1[z]>y1)
                        {
                           for(i=y1;i<pt1[z];i+=80)
                           {
                                for(j=0;j<=15;j++)
                                {
                                        if(pl1[j]==x1 && pt1[j]==i)
                                        {
                                        flag=true;
                                         break;
                                        }
                                        else
                                        {
                                        flag=false;
                                        }

                                }
                                if(flag==true)
                                {
                                break;
                                }
                           }
                           if(flag==true)
                           {wrongselection();    }
                           else
                           {
                                         for(j=0;j<=15;j++)
                                         {
                                                if(x1==pl2[j] && y1==pt2[j])
                                                {
                                                pl2[j]=-200;
                                                pt2[j]=-200;
                                                }
                                         }
                                        
                                          pl1[z]=x1;
                                          pt1[z]=y1;
                                          repaint();
                                          c=0;
                                          if(mate2()==true)
                                          {wrongselectcheck(); }
                                          else
                                          {

                                          if(play==true)
                                           {
                                         m=new mymessage("my chess","Player2's Round");
                                         play=false;
                                           }
                                          else
                                            {
                                          m=new mymessage("my chess","Player1's Round");
                                          play=true;
                                            }
                                         m.setVisible(true);
                                         m.setSize(300,250);
                                         }

                           }


                        }
                        else if(pt1[z]==y1 && pl1[z]<x1)
                        {
                           for(i=pl1[z]+80;i<=x1;i+=80)
                           {
                                for(j=0;j<=15;j++)
                                {
                                        if(pt1[j]==y1 && pl1[j]==i)
                                        {
                                       flag=true;
                                         break;
                                        }
                                        else
                                        {
                                       flag=false;
                                        }

                                }
                                if(flag==true)
                                {
                                break;
                                }
                           }
                           if(flag==true)
                           {wrongselection();     }
                           else
                           {
                                         for(j=0;j<=15;j++)
                                         {
                                                if(x1==pl2[j] && y1==pt2[j])
                                                {
                                                pl2[j]=-200;
                                                pt2[j]=-200;
                                                }
                                         }
                                        
                                          pl1[z]=x1;
                                          pt1[z]=y1;
                                          repaint();
                                          c=0;
                                          if(mate2()==true)
                                          {wrongselectcheck(); }
                                          else
                                          {

                                          if(play==true)
                                           {
                                         m=new mymessage("my chess","Player2's Round");
                                         play=false;
                                           }
                                          else
                                            {
                                          m=new mymessage("my chess","Player1's Round");
                                          play=true;
                                            }
                                         m.setVisible(true);
                                         m.setSize(300,250);
                                         }

                           }

                        }
                        else if(pt1[z]==y1 && pl1[z]>x1)
                        {
                           for(i=x1;i<pl1[z];i+=80)
                           {
                                for(j=0;j<=15;j++)
                                {
                                        if(pt1[j]==y1 && pl1[j]==i)
                                        {
                                        flag=true;
                                        break;
                                        }
                                        else
                                        {
                                        flag=false;
                                        }

                                }
                                if(flag==true)
                                {
                                break;
                                }
                           }
                           if(flag==true)
                           {wrongselection();     }
                           else
                           {
                                         for(j=0;j<=15;j++)
                                         {
                                                if(x1==pl2[j] && y1==pt2[j])
                                                {
                                                pl2[j]=-200;
                                                pt2[j]=-200;
                                                }
                                         }
                                        
                                          pl1[z]=x1;
                                          pt1[z]=y1;
                                          repaint();
                                          c=0;
                                          if(mate2()==true)
                                          {wrongselectcheck();}
                                          else
                                          {

                                          if(play==true)
                                           {
                                         m=new mymessage("my chess","Player2's Round");
                                         play=false;
                                           }
                                          else
                                            {
                                          m=new mymessage("my chess","Player1's Round");
                                          play=true;
                                            }
                                         m.setVisible(true);
                                         m.setSize(300,250);
                                         }

                           }

                         }

                          else if(x1<pl1[z] && y1<pt1[z])
                                {
                                   for(i=x1,j=y1;i<pl1[z];i+=80,j+=80)
                                   {
                                        for(n=0;n<=15;n++)
                                        {
                                                if(i==pl1[n] && j==pt1[n])
                                                {
                                                        flag=true;
                                                        break;
                                                }
                                                else
                                                {
                                                        flag=false;
                                                }
                                        }
                                        if(flag==true)
                                        {
                                        break;
                                        }
                                   }
                           if(flag==true)
                           {wrongselection();      }
                           else
                           {
                                         for(j=0;j<=15;j++)
                                         {
                                                if(x1==pl2[j] && y1==pt2[j])
                                                {
                                                pl2[j]=-200;
                                                pt2[j]=-200;
                                                }
                                         }
                                        
                                          pl1[z]=x1;
                                          pt1[z]=y1;
                                          repaint();
                                          c=0;
                                          if(mate2()==true)
                                          {wrongselectcheck();}
                                          else
                                          {

                                          if(play==true)
                                           {
                                         m=new mymessage("my chess","Player2's Round");
                                         play=false;
                                           }
                                          else
                                            {
                                          m=new mymessage("my chess","Player1's Round");
                                          play=true;
                                            }
                                         m.setVisible(true);
                                         m.setSize(300,250);
                                         }

                           }
                                  
                         }
                          else if(x1>pl1[z] && y1>pt1[z])
                          {
                                   for(i=pl1[z]+80,j=pt1[z]+80;i<=x1;i+=80,j+=80)
                                   {
                                        for(n=0;n<=15;n++)
                                        {
                                                if(i==pl1[n] && j==pt1[n])
                                                {
                                                        flag=true;
                                                        break;
                                                }
                                                else
                                                {
                                                        flag=false;
                                                }
                                        }
                                        if(flag==true)
                                        {
                                        break;
                                        }
                                   }
                           if(flag==true)
                           {wrongselection();     }
                           else
                           {
                                         for(j=0;j<=15;j++)
                                         {
                                                if(x1==pl2[j] && y1==pt2[j])
                                                {
                                                pl2[j]=-200;
                                                pt2[j]=-200;
                                                }
                                         }
                                        
                                          pl1[z]=x1;
                                          pt1[z]=y1;
                                          repaint();
                                          c=0;
                                          if(mate2()==true)
                                          {wrongselectcheck();}
                                          else
                                          {

                                          if(play==true)
                                           {
                                         m=new mymessage("my chess","Player2's Round");
                                         play=false;
                                           }
                                          else
                                            {
                                          m=new mymessage("my chess","Player1's Round");
                                          play=true;
                                            }
                                         m.setVisible(true);
                                         m.setSize(300,250);
                                         }

                           }
                                
                          }
                          else if(x1>pl1[z] && y1< pt1[z])
                          {
                                   for(i=pl1[z]+80,j=pt1[z]-80;i<=x1;i+=80,j-=80)
                                   {
                                        for(n=0;n<=15;n++)
                                        {
                                                if(i==pl1[n] && j==pt1[n])
                                                {
                                                        flag=true;
                                                        break;
                                                }
                                                else
                                                {
                                                        flag=false;
                                                }
                                        }
                                        if(flag==true)
                                        {
                                        break;
                                        }
                                   }
                           if(flag==true)
                           {wrongselection();     }
                           else
                           {
                                         for(j=0;j<=15;j++)
                                         {
                                                if(x1==pl2[j] && y1==pt2[j])
                                                {
                                                pl2[j]=-200;
                                                pt2[j]=-200;
                                                }
                                         }
                                        
                                          pl1[z]=x1;
                                          pt1[z]=y1;
                                          repaint();
                                          c=0;
                                          if(mate2()==true)
                                          {wrongselectcheck(); }
                                          else
                                          {

                                          if(play==true)
                                           {
                                         m=new mymessage("my chess","Player2's Round");
                                         play=false;
                                           }
                                          else
                                            {
                                          m=new mymessage("my chess","Player1's Round");
                                          play=true;
                                            }
                                         m.setVisible(true);
                                         m.setSize(300,250);
                                         }

                           }
                                
                          }
                          else if(x1<pl1[z] && y1>pt1[z])
                          {
                                   for(i=x1,j=y1;i<pl1[z];i+=80,j-=80)
                                   {
                                        for(n=0;n<=15;n++)
                                        {
                                                if(i==pl1[n] && j==pt1[n])
                                                {
                                                        flag=true;
                                                        break;
                                                }
                                                else
                                                {
                                                        flag=false;
                                                }
                                        }
                                        if(flag==true)
                                        {
                                        break;
                                        }
                                   }
                           if(flag==true)
                           {wrongselection();     }
                           else
                           {
                                         for(j=0;j<=15;j++)
                                         {
                                                if(x1==pl2[j] && y1==pt2[j])
                                                {
                                                pl2[j]=-200;
                                                pt2[j]=-200;
                                                }
                                         }
                                        
                                          pl1[z]=x1;
                                          pt1[z]=y1;
                                          repaint();
                                          c=0;
                                          if(mate2()==true)
                                          {wrongselectcheck();}
                                          else
                                          {

                                          if(play==true)
                                           {
                                         m=new mymessage("my chess","Player2's Round");
                                         play=false;
                                           }
                                          else
                                            {
                                          m=new mymessage("my chess","Player1's Round");
                                          play=true;
                                            }
                                         m.setVisible(true);
                                         m.setSize(300,250);
                                         }

                           }
                                
                          }


                                      
                        }
                        else
                        {wrongselection();     }
                        if(mate1())
                        {wrongcheck();	}
         
           }

           boolean piyada1(int z,boolean start)
           {
                        if((pt1[z]+80==y1 && pl1[z]==x1) || (pt1[z]+160==y1 && pl1[z]==x1 && start==true))
                        {
                                if(start==true)
                                {
                                 for(i=pt1[z]+80;i<=y1;i+=80)
                                {
                                for(j=0;j<=15;j++)
                                {
                                        if((pl1[j]==x1 && pt1[j]==i) ||(pl2[j]==x1 && pt2[j]==i))
                                        {
                                         flag=true;
                                         break;
                                        }
                                        else
                                        {
                                          flag=false;
                                        }
                                }
                                if(flag==true)
                                {
                                break;
                                }
                                
                                 }
                           if(flag==true)
                           {wrongselection();     }
                           else
                           {
                                          start=false;
                                          pl1[z]=x1;
                                          pt1[z]=y1;
                                          repaint();
                                          c=0;
                                          if(mate2()==true)
                                          {wrongselectcheck();}
                                          else
                                          {

                                          if(play==true)
                                           {
                                         m=new mymessage("my chess","Player2's Round");
                                         play=false;
                                           }
                                          else
                                            {
                                          m=new mymessage("my chess","Player1's Round");
                                          play=true;
                                            }
                                         m.setVisible(true);
                                         m.setSize(300,250);
                                         }

                           }

                          }
                          else
                          {
                                for(j=0;j<=15;j++)
                                {
                                        if((x1==pl1[j] && y1==pt1[j]) || (x1==pl2[j] && y1==pt2[j]))
                                        {
                                        flag=true;
                                        break;
                                        }
                                        else
                                        {
                                        flag=false;
                                        }
                                }


                           if(flag==true)
                           {wrongselection();     }
                           else
                           {
                                         start=false;
                                          pl1[z]=x1;
                                          pt1[z]=y1;
                                          repaint();
                                          c=0;
                                          if(mate2()==true)
                                          {wrongselectcheck(); }
                                          else
                                          {

                                          if(play==true)
                                           {
                                         m=new mymessage("my chess","Player2's Round");
                                         play=false;
                                           }
                                          else
                                            {
                                          m=new mymessage("my chess","Player1's Round");
                                          play=true;
                                            }
                                         m.setVisible(true);
                                         m.setSize(300,250);
                                         }

                           }
                                                  
                                        
                          }



                        }
                        else if((pl1[z]+80==x1 && pt1[z]+80==y1) || (pl1[z]-80==x1 && pt1[z]+80==y1))
                        {
                                for(j=0;j<=15;j++)
                                {
                                        if(x1==pl2[j] && y1==pt2[j])
                                        {
                                        pl2[j]=-200;
                                        pt2[j]=-200;
                                        flag=true;
                                        break;
                                        }
                                        else
                                        {
                                        flag=false;
                                        }
                                }
                           if(flag==false)
                           {wrongselection();     }
                           else
                           {
                                
                                         start=false;
                                          pl1[z]=x1;
                                          pt1[z]=y1;
                                          repaint();
                                          c=0;
                                          if(mate2()==true)
                                          {wrongselectcheck();}
                                          else
                                          {

                                          if(play==true)
                                           {
                                         m=new mymessage("my chess","Player2's Round");
                                         play=false;
                                           }
                                          else
                                            {
                                          m=new mymessage("my chess","Player1's Round");
                                          play=true;
                                            }
                                         m.setVisible(true);
                                         m.setSize(300,250);
                                         }

                           }


                        }
                        else
                        {wrongselection();      }

                        if(mate1())
                        {wrongcheck();	}         

                        return start;
                        
           }

           void elephant2(int z)
           {
                        if(pl2[z]==x1 || pt2[z]==y1)
                        {

                        if(pl2[z]==x1 && pt2[z]<y1)
                        {
                           for(i=pt2[z]+80;i<=y1;i+=80)
                           {
                                for(j=0;j<=15;j++)
                                {
                                        if(pl2[j]==x1 && pt2[j]==i)
                                        {
                                         flag=true;
                                         break;
                                        }
                                        else
                                        {
                                          flag=false;
                                        }
                                }
                                if(flag==true)
                                {
                                break;
                                }
                                
                           }
                           if(flag==true)
                           {wrongselection();     }
                           else
                           {
                                         for(j=0;j<=15;j++)
                                         {
                                                if(x1==pl1[j] && y1==pt1[j])
                                                {
                                                pl1[j]=-200;
                                                pt1[j]=-200;
                                                }
                                         }
                                        
                                          pl2[z]=x1;
                                          pt2[z]=y1;
                                          repaint();
                                          c=0;
                                          if(mate1()==true)
                                          {wrongselectcheck();}
                                          else
                                          {

                                          if(play==true)
                                           {
                                         m=new mymessage("my chess","Player2's Round");
                                         play=false;
                                           }
                                          else
                                            {
                                          m=new mymessage("my chess","Player1's Round");
                                          play=true;
                                            }
                                         m.setVisible(true);
                                         m.setSize(300,250);
                                         }

                           }
                        }
                        else if(pl2[z]==x1 && pt2[z]>y1)
                        {
                           for(i=y1;i<pt2[z];i+=80)
                           {
                                for(j=0;j<=15;j++)
                                {
                                        if(pl2[j]==x1 && pt2[j]==i)
                                        {
                                        flag=true;
                                         break;
                                        }
                                        else
                                        {
                                        flag=false;
                                        }

                                }
                                if(flag==true)
                                {
                                break;
                                }
                           }
                           if(flag==true)
                           {wrongselection();    }
                           else
                           {
                                         for(j=0;j<=15;j++)
                                         {
                                                if(x1==pl1[j] && y1==pt1[j])
                                                {
                                                pl1[j]=-200;
                                                pt1[j]=-200;
                                                }
                                         }
                                        
                                          pl2[z]=x1;
                                          pt2[z]=y1;
                                          repaint();
                                          c=0;
                                          if(mate1()==true)
                                          {wrongselectcheck();}
                                          else
                                          {

                                          if(play==true)
                                           {
                                         m=new mymessage("my chess","Player2's Round");
                                         play=false;
                                           }
                                          else
                                            {
                                          m=new mymessage("my chess","Player1's Round");
                                          play=true;
                                            }
                                         m.setVisible(true);
                                         m.setSize(300,250);
                                         }

                           }


                        }
                        else if(pt2[z]==y1 && pl2[z]<x1)
                        {
                           for(i=pl2[z]+80;i<=x1;i+=80)
                           {
                                for(j=0;j<=15;j++)
                                {
                                        if(pt2[j]==y1 && pl2[j]==i)
                                        {
                                       flag=true;
                                         break;
                                        }
                                        else
                                        {
                                       flag=false;
                                        }

                                }
                                if(flag==true)
                                {
                                break;
                                }
                           }
                           if(flag==true)
                           {wrongselection();     }
                           else
                           {
                                         for(j=0;j<=15;j++)
                                         {
                                                if(x1==pl1[j] && y1==pt1[j])
                                                {
                                                pl1[j]=-200;
                                                pt1[j]=-200;
                                                }
                                         }
                                                
                                          pl2[z]=x1;
                                          pt2[z]=y1;
                                          repaint();
                                          c=0;
                                          if(mate1()==true)
                                          {wrongselectcheck();}
                                          else
                                          {

                                          if(play==true)
                                           {
                                         m=new mymessage("my chess","Player2's Round");
                                         play=false;
                                           }
                                          else
                                            {
                                          m=new mymessage("my chess","Player1's Round");
                                          play=true;
                                            }
                                         m.setVisible(true);
                                         m.setSize(300,250);
                                         }

                           }

                        }
                        else if(pt2[z]==y1 && pl2[z]>x1)
                        {
                           for(i=x1;i<pl2[z];i+=80)
                           {
                                for(j=0;j<=15;j++)
                                {
                                        if(pt2[j]==y1 && pl2[j]==i)
                                        {
                                        flag=true;
                                        break;
                                        }
                                        else
                                        {
                                        flag=false;
                                        }

                                }
                                if(flag==true)
                                {
                                break;
                                }
                           }
                           if(flag==true)
                           {wrongselection();    }
                           else
                           {
                                         for(j=0;j<=15;j++)
                                         {
                                                if(x1==pl1[j] && y1==pt1[j])
                                                {
                                                pl1[j]=-200;
                                                pt1[j]=-200;
                                                }
                                         }
                                        
                                          pl2[z]=x1;
                                          pt2[z]=y1;
                                          repaint();
                                          c=0;
                                          if(mate1()==true)
                                          {wrongselectcheck(); }
                                          else
                                          {

                                          if(play==true)
                                           {
                                         m=new mymessage("my chess","Player2's Round");
                                         play=false;
                                           }
                                          else
                                            {
                                          m=new mymessage("my chess","Player1's Round");
                                          play=true;
                                            }
                                         m.setVisible(true);
                                         m.setSize(300,250);
                                         }

                           }

                        }

                     }
                        else
                        {wrongselection();    }

                        if(mate2())
                        {wrongselection();     }
         
                       
           }

           void hourse2(int z)
           {

                        if((pl2[z]+80==x1 && pt2[z]+160==y1) || (pl2[z]-80==x1 && pt2[z]+160==y1) || (pl2[z]+80==x1 && pt2[z]-160==y1) || (pl2[z]-80==x1 && pt2[z]-160==y1) || (pl2[z]+160==x1 && pt2[z]+80==y1) || (pl2[z]+160==x1 && pt2[z]-80==y1) || (pl2[z]-160==x1 && pt2[z]+80==y1) || (pl2[z]-160==x1 && pt2[z]-80==y1) )
                        {
                                for(j=0;j<=15;j++)
                                {
                                        if(x1==pl2[j] && y1==pt2[j])
                                        {
                                        flag=true;
                                        break;
                                        }
                                        else
                                        {
                                        flag=false;
                                        }
                                }


                           if(flag==true)
                           {wrongselection();     }

                           else
                           {
                                         for(j=0;j<=15;j++)
                                         {
                                                if(x1==pl1[j] && y1==pt1[j])
                                                {
                                                pl1[j]=-200;
                                                pt1[j]=-200;
                                                }
                                         }
                                        
                                          pl2[z]=x1;
                                          pt2[z]=y1;
                                          repaint();
                                          c=0;
                                          if(mate1()==true)
                                          {wrongselectcheck();}
                                          else
                                          {

                                          if(play==true)
                                           {
                                         m=new mymessage("my chess","Player2's Round");
                                         play=false;
                                           }
                                          else
                                            {
                                          m=new mymessage("my chess","Player1's Round");
                                          play=true;
                                            }
                                         m.setVisible(true);
                                         m.setSize(300,250);
                                         }
                           }
                        }
                        else
                        {wrongselection();     }

                        if(mate2())
                        {wrongselection();      }                   
            }

            void camal2(int z)
            {

                        if(Math.abs(Math.abs(pl2[z])-Math.abs(x1))==Math.abs(Math.abs(pt2[z])-Math.abs(y1)))
                        {
                                if(x1<pl2[z] && y1<pt2[z])
                                {
                                   for(i=x1,j=y1;i<pl2[z];i+=80,j+=80)
                                   {
                                        for(n=0;n<=15;n++)
                                        {
                                                if(i==pl2[n] && j==pt2[n])
                                                {
                                                        flag=true;
                                                        break;
                                                }
                                                else
                                                {
                                                        flag=false;
                                                }
                                        }
                                        if(flag==true)
                                        {
                                        break;
                                        }
                                   }
                           if(flag==true)
                           {wrongselection();    }
                           else
                           {
                                         for(j=0;j<=15;j++)
                                         {
                                                if(x1==pl1[j] && y1==pt1[j])
                                                {
                                                pl1[j]=-200;
                                                pt1[j]=-200;
                                                }
                                         }
                                        
                                          pl2[z]=x1;
                                          pt2[z]=y1;
                                          repaint();
                                          c=0;
                                          if(mate1()==true)
                                          {wrongselectcheck();}
                                          else
                                          {

                                          if(play==true)
                                           {
                                         m=new mymessage("my chess","Player2's Round");
                                         play=false;
                                           }
                                          else
                                            {
                                          m=new mymessage("my chess","Player1's Round");
                                          play=true;
                                            }
                                         m.setVisible(true);
                                         m.setSize(300,250);
                                         }

                           }
                                  
                         }
                          else if(x1>pl2[z] && y1>pt2[z])
                          {
                                   for(i=pl2[z]+80,j=pt2[z]+80;i<=x1;i+=80,j+=80)
                                   {
                                        for(n=0;n<=15;n++)
                                        {
                                                if(i==pl2[n] && j==pt2[n])
                                                {
                                                        flag=true;
                                                        break;
                                                }
                                                else
                                                {
                                                        flag=false;
                                                }
                                        }
                                        if(flag==true)
                                        {
                                        break;
                                        }
                                   }
                           if(flag==true)
                           {wrongselection();    }
                           else
                           {
                                         for(j=0;j<=15;j++)
                                         {
                                                if(x1==pl1[j] && y1==pt1[j])
                                                {
                                                pl1[j]=-200;
                                                pt1[j]=-200;
                                                }
                                         }
                                        
                                          pl2[z]=x1;
                                          pt2[z]=y1;
                                          repaint();
                                          c=0;
                                          if(mate1()==true)
                                          {wrongselectcheck();}
                                          else
                                          {

                                          if(play==true)
                                           {
                                         m=new mymessage("my chess","Player2's Round");
                                         play=false;
                                           }
                                          else
                                            {
                                          m=new mymessage("my chess","Player1's Round");
                                          play=true;
                                            }
                                         m.setVisible(true);
                                         m.setSize(300,250);
                                         }

                           }
                                
                          }
                          else if(x1>pl2[z] && y1< pt2[z])
                          {
                                   for(i=pl2[z]+80,j=pt2[z]-80;i<=x1;i+=80,j-=80)
                                   {
                                        for(n=0;n<=15;n++)
                                        {
                                                if(i==pl2[n] && j==pt2[n])
                                                {
                                                        flag=true;
                                                        break;
                                                }
                                                else
                                                {
                                                        flag=false;
                                                }
                                        }
                                        if(flag==true)
                                        {
                                        break;
                                        }
                                   }
                           if(flag==true)
                           {wrongselection();    }
                           else
                           {
                                         for(j=0;j<=15;j++)
                                         {
                                                if(x1==pl1[j] && y1==pt1[j])
                                                {
                                                pl1[j]=-200;
                                                pt1[j]=-200;
                                                }
                                         }
                                        
                                          pl2[z]=x1;
                                          pt2[z]=y1;
                                          repaint();
                                          c=0;
                                          if(mate1()==true)
                                          {wrongselectcheck();}
                                          else
                                          {

                                          if(play==true)
                                           {
                                         m=new mymessage("my chess","Player2's Round");
                                         play=false;
                                           }
                                          else
                                            {
                                          m=new mymessage("my chess","Player1's Round");
                                          play=true;
                                            }
                                         m.setVisible(true);
                                         m.setSize(300,250);
                                         }

                           }
                                
                          }
                          else if(x1<pl2[z] && y1>pt2[z])
                          {
                                   for(i=x1,j=y1;i<pl2[z];i+=80,j-=80)
                                   {
                                        for(n=0;n<=15;n++)
                                        {
                                                if(i==pl2[n] && j==pt2[n])
                                                {
                                                        flag=true;
                                                        break;
                                                }
                                                else
                                                {
                                                        flag=false;
                                                }
                                        }
                                        if(flag==true)
                                        {
                                        break;
                                        }
                                   }
                           if(flag==true)
                           {wrongselection();    }
                           else
                           {
                                         for(j=0;j<=15;j++)
                                         {
                                                if(x1==pl1[j] && y1==pt1[j])
                                                {
                                                pl1[j]=-200;
                                                pt1[j]=-200;
                                                }
                                         }
                                        
                                          pl2[z]=x1;
                                          pt2[z]=y1;
                                          repaint();
                                          c=0;
                                          if(mate1()==true)
                                          {wrongselectcheck();}
                                          else
                                          {

                                          if(play==true)
                                           {
                                         m=new mymessage("my chess","Player2's Round");
                                         play=false;
                                           }
                                          else
                                            {
                                          m=new mymessage("my chess","Player1's Round");
                                          play=true;
                                            }
                                         m.setVisible(true);
                                         m.setSize(300,250);
                                         }

                           }
                                
                          }
                        }
                        else
                        {wrongselection();    }

                        if(mate2())
                        {  wrongcheck();	}                    
                        
            }

            void king2(int z)
            {
                if(((pl1[z]+80==x1 && pt1[z]==y1) || (pt1[z]+80==y1 && pl1[z]==x1) || (pl1[z]-80==x1 && pt1[z]==y1) || (pt1[z]-80==y1 && pl1[z]==x1) || (pl1[z]-80==x1&& pt1[z]-80==y1) || (pl1[z]+80==x1&& pt1[z]+80==y1)|| (pl1[z]-80==x1 && pt1[z]+80==y1)|| (pl1[z]+80==x1 && pt1[z]-80==y1)))
                {wrongselection();    }

                else if(((pl2[z]+80==x1 && pt2[z]==y1) || (pt2[z]+80==y1 && pl2[z]==x1) || (pl2[z]-80==x1 && pt2[z]==y1) || (pt2[z]-80==y1 && pl2[z]==x1) || (pl2[z]-80==x1&& pt2[z]-80==y1) || (pl2[z]+80==x1&& pt2[z]+80==y1)|| (pl2[z]-80==x1 && pt2[z]+80==y1)|| (pl2[z]+80==x1 && pt2[z]-80==y1)))
                        {
                                for(j=0;j<=15;j++)
                                {
                                        if(x1==pl2[j] && y1==pt2[j])
                                        {
                                        flag=true;
                                        break;
                                        }
                                        else
                                        {
                                        flag=false;
                                        }
                                }


                           if(flag==true)
                           {wrongselection();    }
                           else
                           {
                                         for(j=0;j<=15;j++)
                                         {
                                                if(x1==pl1[j] && y1==pt1[j])
                                                {
                                                pl1[j]=-200;
                                                pt1[j]=-200;
                                                }
                                         }
                                        
                                          pl2[z]=x1;
                                          pt2[z]=y1;
                                          repaint();
                                          c=0;
                                          if(mate1()==true)
                                          {wrongselectcheck();}
                                          else
                                          {

                                          if(play==true)
                                           {
                                         m=new mymessage("my chess","Player2's Round");
                                         play=false;
                                           }
                                          else
                                            {
                                          m=new mymessage("my chess","Player1's Round");
                                          play=true;
                                            }
                                         m.setVisible(true);
                                         m.setSize(300,250);
                                         }

                           }
                        }
                        else
                        {wrongselection();    }

                        if(mate2())
                        {wrongcheck();	}
                    
                        
            }

            void queen2(int z)
            {

                        if(pl2[z]==x1 || pt2[z]==y1 ||Math.abs(Math.abs(pl2[z])-Math.abs(x1))==Math.abs(Math.abs(pt2[z])-Math.abs(y1)))
                        {
                        if(pl2[z]==x1 && pt2[z]<y1)
                        {
                           for(i=pt2[z]+80;i<=y1;i+=80)
                           {
                                for(j=0;j<=15;j++)
                                {
                                        if(pl2[j]==x1 && pt2[j]==i)
                                        {
                                         flag=true;
                                         break;
                                        }
                                        else
                                        {
                                          flag=false;
                                        }
                                }
                                if(flag==true)
                                {
                                break;
                                }
                                
                           }
                           if(flag==true)
                           {wrongselection(); }
                           else
                           {
                                         for(j=0;j<=15;j++)
                                         {
                                                if(x1==pl1[j] && y1==pt1[j])
                                                {
                                                pl1[j]=-200;
                                                pt1[j]=-200;
                                                }
                                         }
                                        
                                          pl2[z]=x1;
                                          pt2[z]=y1;
                                          repaint();
                                          c=0;
                                          if(mate1()==true)
                                          {wrongselectcheck();}
                                          else
                                          {

                                          if(play==true)
                                           {
                                         m=new mymessage("my chess","Player2's Round");
                                         play=false;
                                           }
                                          else
                                            {
                                          m=new mymessage("my chess","Player1's Round");
                                          play=true;
                                            }
                                         m.setVisible(true);
                                         m.setSize(300,250);
                                         }

                           }
                        }
                        else if(pl2[z]==x1 && pt2[z]>y1)
                        {
                           for(i=y1;i<pt2[z];i+=80)
                           {
                                for(j=0;j<=15;j++)
                                {
                                        if(pl2[j]==x1 && pt2[j]==i)
                                        {
                                        flag=true;
                                         break;
                                        }
                                        else
                                        {
                                        flag=false;
                                        }

                                }
                                if(flag==true)
                                {
                                break;
                                }
                           }
                           if(flag==true)
                           {wrongselection();}
                           else
                           {
                                         for(j=0;j<=15;j++)
                                         {
                                                if(x1==pl1[j] && y1==pt1[j])
                                                {
                                                pl1[j]=-200;
                                                pt1[j]=-200;
                                                }
                                         }
                                        
                                          pl2[z]=x1;
                                          pt2[z]=y1;
                                          repaint();
                                          c=0;
                                          if(mate1()==true)
                                          {wrongselectcheck();}
                                          else
                                          {

                                          if(play==true)
                                           {
                                         m=new mymessage("my chess","Player2's Round");
                                         play=false;
                                           }
                                          else
                                            {
                                          m=new mymessage("my chess","Player1's Round");
                                          play=true;
                                            }
                                         m.setVisible(true);
                                         m.setSize(300,250);
                                         }

                           }


                        }
                        else if(pt2[z]==y1 && pl2[z]<x1)
                        {
                           for(i=pl2[z]+80;i<=x1;i+=80)
                           {
                                for(j=0;j<=15;j++)
                                {
                                        if(pt2[j]==y1 && pl2[j]==i)
                                        {
                                       flag=true;
                                         break;
                                        }
                                        else
                                        {
                                       flag=false;
                                        }

                                }
                                if(flag==true)
                                {
                                break;
                                }
                           }
                           if(flag==true)
                           {wrongselection();}
                           else
                           {
                                         for(j=0;j<=15;j++)
                                         {
                                                if(x1==pl1[j] && y1==pt1[j])
                                                {
                                                pl1[j]=-200;
                                                pt1[j]=-200;
                                                }
                                         }
                                        
                                          pl2[z]=x1;
                                          pt2[z]=y1;
                                          repaint();
                                          c=0;
                                          if(mate1()==true)
                                          {wrongselectcheck();}
                                          else
                                          {

                                          if(play==true)
                                           {
                                         m=new mymessage("my chess","Player2's Round");
                                         play=false;
                                           }
                                          else
                                            {
                                          m=new mymessage("my chess","Player1's Round");
                                          play=true;
                                            }
                                         m.setVisible(true);
                                         m.setSize(300,250);
                                         }

                           }

                        }
                        else if(pt2[z]==y1 && pl2[z]>x1)
                        {
                           for(i=x1;i<pl2[z];i+=80)
                           {
                                for(j=0;j<=15;j++)
                                {
                                        if(pt2[j]==y1 && pl2[j]==i)
                                        {
                                        flag=true;
                                        break;
                                        }
                                        else
                                        {
                                        flag=false;
                                        }

                                }
                                if(flag==true)
                                {
                                break;
                                }
                           }
                           if(flag==true)
                           {wrongselection();}
                           else
                           {
                                         for(j=0;j<=15;j++)
                                         {
                                                if(x1==pl1[j] && y1==pt1[j])
                                                {
                                                pl1[j]=-200;
                                                pt1[j]=-200;
                                                }
                                         }
                                        
                                          pl2[z]=x1;
                                          pt2[z]=y1;
                                          repaint();
                                          c=0;
                                          if(mate1()==true)
                                          {wrongselectcheck();}
                                          else
                                          {

                                          if(play==true)
                                           {
                                         m=new mymessage("my chess","Player2's Round");
                                         play=false;
                                           }
                                          else
                                            {
                                          m=new mymessage("my chess","Player1's Round");
                                          play=true;
                                            }
                                         m.setVisible(true);
                                         m.setSize(300,250);
                                         }

                           }

                         }

                          else if(x1<pl2[z] && y1<pt2[z])
                                {
                                   for(i=x1,j=y1;i<pl2[z];i+=80,j+=80)
                                   {
                                        for(n=0;n<=15;n++)
                                        {
                                                if(i==pl2[n] && j==pt2[n])
                                                {
                                                        flag=true;
                                                        break;
                                                }
                                                else
                                                {
                                                        flag=false;
                                                }
                                        }
                                        if(flag==true)
                                        {
                                        break;
                                        }
                                   }
                           if(flag==true)
                           {wrongselection();}
                           else
                           {
                                         for(j=0;j<=15;j++)
                                         {
                                                if(x1==pl1[j] && y1==pt1[j])
                                                {
                                                pl1[j]=-200;
                                                pt1[j]=-200;
                                                }
                                         }
                                        
                                          pl2[z]=x1;
                                          pt2[z]=y1;
                                          repaint();
                                          c=0;
                                          if(mate1()==true)
                                          {wrongselectcheck();}
                                          else
                                          {

                                          if(play==true)
                                           {
                                         m=new mymessage("my chess","Player2's Round");
                                         play=false;
                                           }
                                          else
                                            {
                                          m=new mymessage("my chess","Player1's Round");
                                          play=true;
                                            }
                                         m.setVisible(true);
                                         m.setSize(300,250);
                                         }

                           }
                                  
                         }
                          else if(x1>pl2[z] && y1>pt2[z])
                          {
                                   for(i=pl2[z]+80,j=pt2[z]+80;i<=x1;i+=80,j+=80)
                                   {
                                        for(n=0;n<=15;n++)
                                        {
                                                if(i==pl2[n] && j==pt2[n])
                                                {
                                                        flag=true;
                                                        break;
                                                }
                                                else
                                                {
                                                        flag=false;
                                                }
                                        }
                                        if(flag==true)
                                        {
                                        break;
                                        }
                                   }
                           if(flag==true)
                           {wrongselection();  }
                           else
                           {
                                         for(j=0;j<=15;j++)
                                         {
                                                if(x1==pl1[j] && y1==pt1[j])
                                                {
                                                pl1[j]=-200;
                                                pt1[j]=-200;
                                                }
                                         }
                                        
                                          pl2[z]=x1;
                                          pt2[z]=y1;
                                          repaint();
                                          c=0;
                                          if(mate1()==true)
                                          {wrongselectcheck();}
                                          else
                                          {

                                          if(play==true)
                                           {
                                         m=new mymessage("my chess","Player2's Round");
                                         play=false;
                                           }
                                          else
                                            {
                                          m=new mymessage("my chess","Player1's Round");
                                          play=true;
                                            }
                                         m.setVisible(true);
                                         m.setSize(300,250);
                                         }

                           }
                                
                          }
                          else if(x1>pl2[z] && y1< pt2[z])
                          {
                                   for(i=pl2[z]+80,j=pt2[z]-80;i<=x1;i+=80,j-=80)
                                   {
                                        for(n=0;n<=15;n++)
                                        {
                                                if(i==pl2[n] && j==pt2[n])
                                                {
                                                        flag=true;
                                                        break;
                                                }
                                                else
                                                {
                                                        flag=false;
                                                }
                                        }
                                        if(flag==true)
                                        {
                                        break;
                                        }
                                   }
                           if(flag==true)
                           {wrongselection(); }
                           else
                           {
                                         for(j=0;j<=15;j++)
                                         {
                                                if(x1==pl1[j] && y1==pt1[j])
                                                {
                                                pl1[j]=-200;
                                                pt1[j]=-200;
                                                }
                                         }
                                        
                                          pl2[z]=x1;
                                          pt2[z]=y1;
                                          repaint();
                                          c=0;
                                          if(mate1()==true)
                                          {wrongselectcheck();}
                                          else
                                          {

                                          if(play==true)
                                           {
                                         m=new mymessage("my chess","Player2's Round");
                                         play=false;
                                           }
                                          else
                                            {
                                          m=new mymessage("my chess","Player1's Round");
                                          play=true;
                                            }
                                         m.setVisible(true);
                                         m.setSize(300,250);
                                         }

                           }
                                
                          }
                          else if(x1<pl2[z] && y1>pt2[z])
                          {
                                   for(i=x1,j=y1;i<pl2[z];i+=80,j-=80)
                                   {
                                        for(n=0;n<=15;n++)
                                        {
                                                if(i==pl2[n] && j==pt2[n])
                                                {
                                                        flag=true;
                                                        break;
                                                }
                                                else
                                                {
                                                        flag=false;
                                                }
                                        }
                                        if(flag==true)
                                        {
                                        break;
                                        }
                                   }
                           if(flag==true)
                           {wrongselection();}

                           else
                           {
                                         for(j=0;j<=15;j++)
                                         {
                                                if(x1==pl1[j] && y1==pt1[j])
                                                {
                                                pl1[j]=-200;
                                                pt1[j]=-200;
                                                }
                                         }
                                        
                                          pl2[z]=x1;
                                          pt2[z]=y1;
                                          repaint();
                                          c=0;
                                          if(mate1()==true)
                                          {wrongselectcheck();}     
                                          
                                          else
                                          {

                                          if(play==true)
                                           {
                                         m=new mymessage("my chess","Player2's Round");
                                         play=false;
                                           }
                                          else
                                            {
                                          m=new mymessage("my chess","Player1's Round");
                                          play=true;
                                            }
                                         m.setVisible(true);
                                         m.setSize(300,250);
                                         }

                           }
                                
                          }


                                      
                        }
                        else
                        {wrongselection(); }

                        if(mate2())
                        {wrongcheck();	 }
                    
                        
            }

            boolean piyada2(int z,boolean start)
            {
                        if((pt2[z]-80==y1 && pl2[z]==x1) || (pt2[z]-160==y1 && pl2[z]==x1 && start==true))
                        {
                                if(start==true)
                                {
                                 for(i=pt2[z]-80;i>=y1;i-=80)
                                {
                                for(j=0;j<=15;j++)
                                {
                                        if((pl2[j]==x1 && pt2[j]==i)||(pl1[j]==x1 && pt1[j]==i))
                                        {
                                         flag=true;
                                         break;
                                        }
                                        else
                                        {
                                          flag=false;
                                        }
                                }
                                if(flag==true)
                                {
                                break;
                                }
                                
                                 }
                           if(flag==true)
                           {wrongselection();  }
                           else
                           {
                           start=false;
                                          pl2[z]=x1;
                                          pt2[z]=y1;
                                          repaint();
                                          c=0;
                                          if(mate1()==true)
                                          {wrongselectcheck();}
                                          else
                                          {

                                          if(play==true)
                                           {
                                         m=new mymessage("my chess","Player2's Round");
                                         play=false;
                                           }
                                          else
                                            {
                                          m=new mymessage("my chess","Player1's Round");
                                          play=true;
                                            }
                                         m.setVisible(true);
                                         m.setSize(300,250);
                                         }

                           }

                          }
                          else
                          {
                                for(j=0;j<=15;j++)
                                {
                                        if((x1==pl2[j] && y1==pt2[j])||(pl1[j]==x1 && pt1[j]==y1))
                                        {
                                        flag=true;
                                        break;
                                        }
                                        else
                                        {
                                        flag=false;
                                        }
                                }


                           if(flag==true)
                           {wrongselection();}
                           else
                           {
                            start=false;
                                          pl2[z]=x1;
                                          pt2[z]=y1;
                                          repaint();
                                          c=0;
                                          if(mate1()==true)
                                          {wrongselectcheck();}
                                          else
                                          {

                                          if(play==true)
                                           {
                                         m=new mymessage("my chess","Player2's Round");
                                         play=false;
                                           }
                                          else
                                            {
                                          m=new mymessage("my chess","Player1's Round");
                                          play=true;
                                            }
                                         m.setVisible(true);
                                         m.setSize(300,250);
                                         }

                           }
                                                  
                                        
                          }


                        }
                        else if((pl2[z]-80==x1 && pt2[z]-80==y1) || (pl2[z]+80==x1 && pt2[z]-80==y1))
                        {
                                for(j=0;j<=15;j++)
                                {
                                        if(x1==pl1[j] && y1==pt1[j])
                                        {
                                        pl1[j]=-200;
                                        pt1[j]=-200;
                                        flag=true;
                                        break;
                                        }
                                        else
                                        {
                                        flag=false;
                                        }
                                }
                           if(flag==false)
                           {wrongselection(); }
                           else
                           {
                                
                                         start=false;
                                          pl2[z]=x1;
                                          pt2[z]=y1;
                                          repaint();
                                          c=0;
                                          if(mate1()==true)
                                          {wrongselectcheck(); }
                                          else
                                          {

                                          if(play==true)
                                           {
                                         m=new mymessage("my chess","Player2's Round");
                                         play=false;
                                           }
                                          else
                                            {
                                          m=new mymessage("my chess","Player1's Round");
                                          play=true;
                                            }
                                         m.setVisible(true);
                                         m.setSize(300,250);
                                         }

                           }


                        }

                        else
                        {wrongselection(); }
                        if(mate2())
                        {wrongcheck();	 }


                        return start;
                        
            }



        void change()
        {
                for(i=8;i<=15;i++)
                {
                        if(((pl1[i]==0 && pt1[i]==560) || (pl1[i]==560 && pt1[i]==560)) && role[i%8]=='p')
                        {
                                role[i%8]='e';
                                setpicture1(i,"g.jpg");
                                if(matebyelephant1(i%8))
                                {wrongcheck();	}
                        }
                        else if(((pl1[i]==80 && pt1[i]==560) || (pl1[i]==480 && pt1[i]==560)) && role[i%8]=='p')
                        {
                                role[i%8]='h';
                                setpicture1(i,"g1.jpg");
                                if(matebyhourse1(i%8))
                                {wrongcheck();	}

                        }
                        else if(((pl1[i]==160 && pt1[i]==560) || (pl1[i]==400 && pt1[i]==560)) && role[i%8]=='p')
                        {
                                role[i%8]='c';
                                setpicture1(i,"g2.jpg");
                                if(matebycamal1(i%8))
                                {wrongcheck();	}

                        }
                        else if(((pl1[i]==240 && pt1[i]==560)) && role[i%8]=='p')
                        {
                                role[i%8]='q';
                                setpicture1(i,"g3.jpg");
                                if(matebyqueen1(i%8))
                                {wrongcheck();	}

                        }

                        else if(((pl1[i]==320 && pt1[i]==560)) && role[i%8]=='p')
                        {
                                role[i%8]='q';
                                setpicture1(i,"g3.jpg");
                                if(matebyqueen1(i%8))
                                {wrongcheck();	}

                        }

                        
                }

                for(i=8;i<=15;i++)
                {
                        if(((pl2[i]==0 && pt2[i]==0) || (pl2[i]==560 && pt2[i]==0)) && role[i]=='p')
                        {
                                role[i]='e';
                                setpicture2(i,"h.jpg");
                                if(matebyelephant2(i))
                                {wrongcheck();	 }


                        }
                        else if(((pl2[i]==80 && pt2[i]==0) || (pl2[i]==480 && pt2[i]==0)) && role[i]=='p')
                        {
                                role[i]='h';
                                setpicture2(i,"h1.jpg");
                                if(matebyhourse2(i))
                                {wrongcheck();	}

                        }
                        else if(((pl2[i]==160 && pt2[i]==0) || (pl2[i]==400 && pt2[i]==0)) && role[i]=='p')
                        {
                                role[i]='c';
                                setpicture2(i,"h2.jpg");
                                if(matebycamal2(i))
                                {wrongcheck();	  }

                        }
                        else if(((pl2[i]==240 && pt2[i]==0)) && role[i]=='p')
                        {
                                role[i]='q';
                                setpicture2(i,"h3.jpg");

                                if(matebyqueen2(i))
                                {wrongcheck();	}

                        }

                        else if(((pl2[i]==320 && pt2[i]==0)) && role[i]=='p')
                        {
                                role[i]='q';
                                 setpicture2(i,"h3.jpg");

                                if(matebyqueen2(i))
                                {	wrongcheck();	}

                        }

                        
                }


        }

        void setpicture1(int i,String path)
        {
                                switch(i)
                                {
                                case 8:
                                        img9=getImage(getDocumentBase(),path);
                                        break;
                                case 9:
                                        img10=getImage(getDocumentBase(),path);
                                        break;
                                case 10:     
                                        img11=getImage(getDocumentBase(),path);
                                        break;
                                case 11:
                                        img12=getImage(getDocumentBase(),path);
                                        break;
                                case 12:
                                        img13=getImage(getDocumentBase(),path);
                                        break;
                                case 13:
                                        img14=getImage(getDocumentBase(),path);
                                        break;
                                case 14:
                                        img15=getImage(getDocumentBase(),path);
                                        break;
                                case 15:
                                        img16=getImage(getDocumentBase(),path);
                                        break;

                                }
                
        }
        void setpicture2(int i,String path)
        {
                                switch(i)
                                {
                                case 8:
                                        imge9=getImage(getDocumentBase(),path);
                                        break;
                                case 9:
                                        imge10=getImage(getDocumentBase(),path);
                                        break;
                                case 10:
                                        imge11=getImage(getDocumentBase(),path);
                                        break;
                                case 11:
                                        imge12=getImage(getDocumentBase(),path);
                                        break;
                                case 12:
                                        imge13=getImage(getDocumentBase(),path);
                                        break;
                                case 13:
                                        imge14=getImage(getDocumentBase(),path);
                                        break;
                                case 14:
                                        imge15=getImage(getDocumentBase(),path);
                                        break;
                                case 15:
                                        imge16=getImage(getDocumentBase(),path);
                                        break;

                                }
                
        }

        boolean matebyelephant1(int z)
        {

                if(pl2[4]==pl1[z] && pt2[4]>pt1[z])
                {
                        for(i=pt1[z]+80;i<=pt2[4];i+=80)
                        {
                            for(j=0;j<=15;j++)
                            {
                                if((pl2[4]==pl1[j] && i==pt1[j]) ||(pl2[4]==pl2[j] && i==pt2[j] && j!=4))
                                {
                                check=false;
                                break;
                                }
                                else
                                {
                                check=true;
                                }
                            }
                            if(check==false)
                            {
                            break;
                            }
                        }
                      
                }
                else if(pl2[4]==pl1[z] && pt2[4]<pt1[z])
                {
                        for(i=pt1[z]-80;i>=pt2[4];i-=80)
                        {
                            for(j=0;j<=15;j++)
                            {
                                if((pl2[4]==pl1[j] && i==pt1[j]) ||(pl2[4]==pl2[j] && i==pt2[j] && j!=4))
                                {
                                check=false;
                                break;
                                }
                                else
                                {
                                check=true;
                                }
                            }
                            if(check==false)
                            {
                            break;
                            }
                        }
                }
                else if(pt2[4]==pt1[z] && pl2[4]>pl1[z])
                {
                        for(i=pl1[z]+80;i<=pl2[4];i+=80)
                        {
                            for(j=0;j<=15;j++)
                            {
                                if((pt2[4]==pt1[j] && i==pl1[j]) ||(pt2[4]==pt2[j] && i==pl2[j] && j!=4))
                                {
                                check=false;
                                break;
                                }
                                else
                                {
                                check=true;
                                }
                            }
                            if(check==false)
                            {
                            break;
                            }
                        }
                }
                else if(pt2[4]==pt1[z] && pl2[4]<pl1[z])
                {
                        for(i=pl1[z]-80;i>=pl2[4];i-=80)
                        {
                            for(j=0;j<=15;j++)
                            {
                                if((pt2[4]==pt1[j] && i==pl1[j]) ||(pt2[4]==pt2[j] && i==pl2[j] && j!=4))
                                {
                                check=false;
                                break;
                                }
                                else
                                {
                                check=true;
                                }
                            }
                            if(check==false)
                            {
                            break;
                            }
                        }
                }
                  return check;

        }

        boolean matebyhourse1(int z)
        {
                  if((pl1[z]+80==pl2[4] && pt1[z]+160==pt2[4]) || (pl1[z]-80==pl2[4] && pt1[z]+160==pt2[4]) || (pl1[z]+80==pl2[4] && pt1[z]-160==pt2[4]) || (pl1[z]-80==pl2[4] && pt1[z]-160==pt2[4]) || (pl1[z]+160==pl2[4] && pt1[z]+80==pt2[4]) || (pl1[z]+160==pl2[4] && pt1[z]-80==pt2[4]) || (pl1[z]-160==pl2[4] && pt1[z]+80==pt2[4]) || (pl1[z]-160==pl2[4] && pt1[z]-80==pt2[4]) )
                  {
                            
                                check=true;

                  }
                  else
                  {
                  check=false;
                  }
                  return check;
        
        }
        boolean matebycamal1(int z)
        {
                     if(Math.abs(Math.abs(pl1[z])-Math.abs(pl2[4]))==Math.abs(Math.abs(pt1[z])-Math.abs(pt2[4])))
                     {
                                if(pl2[4]<pl1[z] && pt2[4]<pt1[z])
                                {
                                   for(i=pl2[4],j=pt2[4];i<pl1[z];i+=80,j+=80)
                                   {
                                        for(n=0;n<=15;n++)
                                        {
                                                if((i==pl1[n] && j==pt1[n]) || (i==pl2[n] && j==pt2[n] && n!=4))
                                                {
                                                        check=false;
                                                        break;
                                                }
                                                else
                                                {
                                                        check=true;
                                                }
                                        }
                                
                                      if(check==false)
                                      {
                                      break;
                                      }
                                    }
                                    

                                }
                                else if(pl2[4]>pl1[z] && pt2[4]>pt1[z])
                                {
                                   for(i=pl2[4],j=pt2[4];i>pl1[z];i-=80,j-=80)
                                   {
                                        for(n=0;n<=15;n++)
                                        {
                                                if((i==pl1[n] && j==pt1[n]) || (i==pl2[n] && j==pt2[n] && n!=4))
                                                {
                                                        check=false;
                                                        break;
                                                }
                                                else
                                                {
                                                        check=true;
                                                }
                                        }
                                
                                      if(check==false)
                                      {
                                      break;
                                      }
                                    }

                                    

                                }
                                else if(pl2[4]<pl1[z] && pt2[4]>pt1[z])
                                {
                                   for(i=pl2[4],j=pt2[4];i<pl1[z];i+=80,j-=80)
                                   {
                                        for(n=0;n<=15;n++)
                                        {
                                                if((i==pl1[n] && j==pt1[n]) || (i==pl2[n] && j==pt2[n] && n!=4))
                                                {
                                                        check=false;
                                                        break;
                                                }
                                                else
                                                {
                                                        check=true;
                                                }
                                        }
                                
                                      if(check==false)
                                      {
                                      break;
                                      }
                                    }
                                    

                                }
                                else if(pl2[4]>pl1[z] && pt2[4]<pt1[z])
                                {
                                   for(i=pl2[4],j=pt2[4];i>pl1[z];i-=80,j+=80)
                                   {
                                        for(n=0;n<=15;n++)
                                        {
                                                if((i==pl1[n] && j==pt1[n]) || (i==pl2[n] && j==pt2[n] && n!=4))
                                                {
                                                        check=false;
                                                        break;
                                                }
                                                else
                                                {
                                                        check=true;
                                                }
                                        }
                                
                                      if(check==false)
                                      {
                                      break;
                                      }
                                    }
                                    

                                }


               }
                 return check;
        }
        boolean matebyqueen1(int z)
        {
                 
                if(pl2[4]==pl1[z] && pt2[4]>pt1[z])
                {
                        for(i=pt1[z]+80;i<=pt2[4];i+=80)
                        {
                            for(j=0;j<=15;j++)
                            {
                                if((pl2[4]==pl1[j] && i==pt1[j]) ||(pl2[4]==pl2[j] && i==pt2[j] && j!=4))
                                {
                                check=false;
                                break;
                                }
                                else
                                {
                                check=true;
                                }
                            }
                            if(check==false)
                            {
                            break;
                            }
                        }
                }
                else if(pl2[4]==pl1[z] && pt2[4]<pt1[z])
                {
                        for(i=pt1[z]-80;i>=pt2[4];i-=80)
                        {
                            for(j=0;j<=15;j++)
                            {
                                if((pl2[4]==pl1[j] && i==pt1[j]) ||(pl2[4]==pl2[j] && i==pt2[j] && j!=4))
                                {
                                check=false;
                                break;
                                }
                                else
                                {
                                check=true;
                                }
                            }
                            if(check==false)
                            {
                            break;
                            }
                        }
                }
                else if(pt2[4]==pt1[z] && pl2[4]>pl1[z])
                {
                        for(i=pl1[z]+80;i<=pl2[4];i+=80)
                        {
                            for(j=0;j<=15;j++)
                            {
                                if((pt2[4]==pt1[j] && i==pl1[j]) ||(pt2[4]==pt2[j] && i==pl2[j] && j!=4))
                                {
                                check=false;
                                break;
                                }
                                else
                                {
                                check=true;
                                }
                            }
                            if(check==false)
                            {
                            break;
                            }
                        }
                }
                else if(pt2[4]==pt1[z] && pl2[4]<pl1[z])
                {
                        for(i=pl1[z]-80;i>=pl2[4];i-=80)
                        {
                            for(j=0;j<=15;j++)
                            {
                                if((pt2[4]==pt1[j] && i==pl1[j]) ||(pt2[4]==pt2[j] && i==pl2[j] && j!=4))
                                {
                                check=false;
                                break;
                                }
                                else
                                {
                                check=true;
                                }
                            }
                            if(check==false)
                            {
                            break;
                            }
                        }
                }
                else if(Math.abs(Math.abs(pl1[z])-Math.abs(pl2[4]))==Math.abs(Math.abs(pt1[z])-Math.abs(pt2[4])))
                {
                    if(pl2[4]<pl1[z] && pt2[4]<pt1[z])
                                {
                                   for(i=pl2[4],j=pt2[4];i<pl1[z];i+=80,j+=80)
                                   {
                                        for(n=0;n<=15;n++)
                                        {
                                                if((i==pl1[n] && j==pt1[n]) || (i==pl2[n] && j==pt2[n] && n!=4))
                                                {
                                                        check=false;
                                                        break;
                                                }
                                                else
                                                {
                                                        check=true;
                                                }
                                        }
                                
                                      if(check==false)
                                      {
                                      break;
                                      }
                                    }
                                 if(check==true)
                                  {
                                 c=0;
                                 m=new mymessage("my chess","Check");
                                 m.setVisible(true);
                                 m.setSize(300,250);

                                  }
                                    

                                }
                                else if(pl2[4]>pl1[z] && pt2[4]>pt1[z])
                                {
                                   for(i=pl2[4],j=pt2[4];i>pl1[z];i-=80,j-=80)
                                   {
                                        for(n=0;n<=15;n++)
                                        {
                                                if((i==pl1[n] && j==pt1[n]) || (i==pl2[n] && j==pt2[n] && n!=4))
                                                {
                                                        check=false;
                                                        break;
                                                }
                                                else
                                                {
                                                        check=true;
                                                }
                                        }
                                
                                      if(check==false)
                                      {
                                      break;
                                      }
                                    }

                                    

                                }
                                else if(pl2[4]<pl1[z] && pt2[4]>pt1[z])
                                {
                                   for(i=pl2[4],j=pt2[4];i<pl1[z];i+=80,j-=80)
                                   {
                                        for(n=0;n<=15;n++)
                                        {
                                                if((i==pl1[n] && j==pt1[n]) || (i==pl2[n] && j==pt2[n] && n!=4))
                                                {
                                                        check=false;
                                                        break;
                                                }
                                                else
                                                {
                                                        check=true;
                                                }
                                        }
                                
                                      if(check==false)
                                      {
                                      break;
                                      }
                                    }
                                    

                                }
                                else if(pl2[4]>pl1[z] && pt2[4]<pt1[z])
                                {
                                   for(i=pl2[4],j=pt2[4];i>pl1[z];i-=80,j+=80)
                                   {
                                        for(n=0;n<=15;n++)
                                        {
                                                if((i==pl1[n] && j==pt1[n]) || (i==pl2[n] && j==pt2[n] && n!=4))
                                                {
                                                        check=false;
                                                        break;
                                                }
                                                else
                                                {
                                                        check=true;
                                                }
                                        }
                                
                                      if(check==false)
                                      {
                                      break;
                                      }
                                    }
                                    

                                }


                   }

                 return check; 
        }
        boolean matebypiyada1(int z)
        {
                  if((pl1[z]+80==pl2[4] && pt1[z]+80==pt2[4]) || (pl1[z]-80==pl2[4] && pt1[z]+80==pt2[4]) )
                  {
                               
                                check=true;


                  }
                  else
                  {
                  check=false;
                  }
                    return check;
                
        }


        boolean matebyelephant2(int z)
        {

                if(pl1[4]==pl2[z] && pt1[4]>pt2[z])
                {
                        for(i=pt2[z]+80;i<=pt1[4];i+=80)
                        {
                            for(j=0;j<=15;j++)
                            {
                                if((pl1[4]==pl2[j] && i==pt2[j]) ||(pl1[4]==pl1[j] && i==pt1[j] && j!=4))
                                {
                                check=false;
                                break;
                                }
                                else
                                {
                                check=true;
                                }
                            }
                            if(check==false)
                            {
                            break;
                            }
                        }
                }
                else if(pl1[4]==pl2[z] && pt1[4]<pt2[z])
                {
                        for(i=pt2[z]-80;i>=pt1[4];i-=80)
                        {
                            for(j=0;j<=15;j++)
                            {
                                if((pl1[4]==pl2[j] && i==pt2[j]) ||(pl1[4]==pl1[j] && i==pt1[j] && j!=4))
                                {
                                check=false;
                                break;
                                }
                                else
                                {
                                check=true;
                                }
                            }
                            if(check==false)
                            {
                            break;
                            }
                        }
                }
                else if(pt1[4]==pt2[z] && pl1[4]>pl2[z])
                {
                        for(i=pl2[z]+80;i<=pl1[4];i+=80)
                        {
                            for(j=0;j<=15;j++)
                            {
                                if((pt1[4]==pt2[j] && i==pl2[j]) ||(pt1[4]==pt1[j] && i==pl1[j] && j!=4))
                                {
                                check=false;
                                break;
                                }
                                else
                                {
                                check=true;
                                }
                            }
                            if(check==false)
                            {
                            break;
                            }
                        }
                }
                else if(pt1[4]==pt2[z] && pl1[4]<pl2[z])
                {
                        for(i=pl2[z]-80;i>=pl1[4];i-=80)
                        {
                            for(j=0;j<=15;j++)
                            {
                                if((pt1[4]==pt2[j] && i==pl2[j]) ||(pt1[4]==pt1[j] && i==pl1[j] && j!=4))
                                {
                                check=false;
                                break;
                                }
                                else
                                {
                                check=true;
                                }
                            }
                            if(check==false)
                            {
                            break;
                            }
                        }
                }
                  return check;

        }

        boolean matebyhourse2(int z)
        {
                  if((pl2[z]+80==pl1[4] && pt2[z]+160==pt1[4]) || (pl2[z]-80==pl1[4] && pt2[z]+160==pt1[4]) || (pl2[z]+80==pl1[4] && pt2[z]-160==pt1[4]) || (pl2[z]-80==pl1[4] && pt2[z]-160==pt1[4]) || (pl2[z]+160==pl1[4] && pt2[z]+80==pt1[4]) || (pl2[z]+160==pl1[4] && pt2[z]-80==pt1[4]) || (pl2[z]-160==pl1[4] && pt2[z]+80==pt1[4]) || (pl2[z]-160==pl1[4] && pt2[z]-80==pt1[4]) )
                  {
                      
                                check=true;

                  }
                  else
                  {
                  check=false;
                  }
                    return check;
        
        }
        boolean matebycamal2(int z)
        {
                     if(Math.abs(Math.abs(pl2[z])-Math.abs(pl1[4]))==Math.abs(Math.abs(pt2[z])-Math.abs(pt1[4])))
                     {
                                if(pl1[4]<pl2[z] && pt1[4]<pt2[z])
                                {
                                   for(i=pl1[4],j=pt1[4];i<pl2[z];i+=80,j+=80)
                                   {
                                        for(n=0;n<=15;n++)
                                        {
                                                if((i==pl2[n] && j==pt2[n]) || (i==pl1[n] && j==pt1[n] && n!=4))
                                                {
                                                        check=false;
                                                        break;
                                                }
                                                else
                                                {
                                                        check=true;
                                                }
                                        }
                                
                                      if(check==false)
                                      {
                                      break;
                                      }
                                    }
                                    

                                }
                                else if(pl1[4]>pl2[z] && pt1[4]>pt2[z])
                                {
                                   for(i=pl1[4],j=pt1[4];i>pl2[z];i-=80,j-=80)
                                   {
                                        for(n=0;n<=15;n++)
                                        {
                                                if((i==pl2[n] && j==pt2[n]) || (i==pl1[n] && j==pt1[n] && n!=4))
                                                {
                                                        check=false;
                                                        break;
                                                }
                                                else
                                                {
                                                        check=true;
                                                }
                                        }
                                
                                      if(check==false)
                                      {
                                      break;
                                      }
                                    }

                                    

                                }
                                else if(pl1[4]<pl2[z] && pt1[4]>pt2[z])
                                {
                                   for(i=pl1[4],j=pt1[4];i<pl2[z];i+=80,j-=80)
                                   {
                                        for(n=0;n<=15;n++)
                                        {
                                                if((i==pl2[n] && j==pt2[n]) || (i==pl1[n] && j==pt1[n] && n!=4))
                                                {
                                                        check=false;
                                                        break;
                                                }
                                                else
                                                {
                                                        check=true;
                                                }
                                        }
                                
                                      if(check==false)
                                      {
                                      break;
                                      }
                                    }
                                    

                                }
                                else if(pl1[4]>pl2[z] && pt1[4]<pt2[z])
                                {
                                   for(i=pl1[4],j=pt1[4];i>pl2[z];i-=80,j+=80)
                                   {
                                        for(n=0;n<=15;n++)
                                        {
                                                if((i==pl2[n] && j==pt2[n]) || (i==pl1[n] && j==pt1[n] && n!=4))
                                                {
                                                        check=false;
                                                        break;
                                                }
                                                else
                                                {
                                                        check=true;
                                                }
                                        }
                                
                                      if(check==false)
                                      {
                                      break;
                                      }
                                    }
                                    

                                }


               }
               return check;
        }
        boolean matebyqueen2(int z)
        {
                 
                if(pl1[4]==pl2[z] && pt1[4]>pt2[z])
                {
                        for(i=pt2[z]+80;i<=pt1[4];i+=80)
                        {
                            for(j=0;j<=15;j++)
                            {
                                if((pl1[4]==pl2[j] && i==pt2[j]) ||(pl1[4]==pl1[j] && i==pt1[j] && j!=4))
                                {
                                check=false;
                                break;
                                }
                                else
                                {
                                check=true;
                                }
                            }
                            if(check==false)
                            {
                            break;
                            }
                        }
                }
                else if(pl1[4]==pl2[z] && pt1[4]<pt2[z])
                {
                        for(i=pt2[z]-80;i>=pt1[4];i-=80)
                        {
                            for(j=0;j<=15;j++)
                            {
                                if((pl1[4]==pl2[j] && i==pt2[j]) ||(pl1[4]==pl1[j] && i==pt1[j] && j!=4))
                                {
                                check=false;
                                break;
                                }
                                else
                                {
                                check=true;
                                }
                            }
                            if(check==false)
                            {
                            break;
                            }
                        }
                }
                else if(pt1[4]==pt2[z] && pl1[4]>pl2[z])
                {
                        for(i=pl2[z]+80;i<=pl1[4];i+=80)
                        {
                            for(j=0;j<=15;j++)
                            {
                                if((pt1[4]==pt2[j] && i==pl2[j]) ||(pt1[4]==pt1[j] && i==pl1[j] && j!=4))
                                {
                                check=false;
                                break;
                                }
                                else
                                {
                                check=true;
                                }
                            }
                            if(check==false)
                            {
                            break;
                            }
                        }
                }
                else if(pt1[4]==pt2[z] && pl1[4]<pl2[z])
                {
                        for(i=pl2[z]-80;i>=pl1[4];i-=80)
                        {
                            for(j=0;j<=15;j++)
                            {
                                if((pt1[4]==pt2[j] && i==pl2[j]) ||(pt1[4]==pt1[j] && i==pl1[j] && j!=4))
                                {
                                check=false;
                                break;
                                }
                                else
                                {
                                check=true;
                                }
                            }
                            if(check==false)
                            {
                            break;
                            }
                        }
                }
                else if(Math.abs(Math.abs(pl2[z])-Math.abs(pl1[4]))==Math.abs(Math.abs(pt2[z])-Math.abs(pt1[4])))
                {
                    if(pl1[4]<pl2[z] && pt1[4]<pt2[z])
                                {
                                   for(i=pl1[4],j=pt1[4];i<pl2[z];i+=80,j+=80)
                                   {
                                        for(n=0;n<=15;n++)
                                        {
                                                if((i==pl2[n] && j==pt2[n]) || (i==pl1[n] && j==pt1[n] && n!=4))
                                                {
                                                        check=false;
                                                        break;
                                                }
                                                else
                                                {
                                                        check=true;
                                                }
                                        }
                                
                                      if(check==false)
                                      {
                                      break;
                                      }
                                    }
                                    

                                }
                                else if(pl1[4]>pl2[z] && pt1[4]>pt2[z])
                                {
                                   for(i=pl1[4],j=pt1[4];i>pl2[z];i-=80,j-=80)
                                   {
                                        for(n=0;n<=15;n++)
                                        {
                                                if((i==pl2[n] && j==pt2[n]) || (i==pl1[n] && j==pt1[n] && n!=4))
                                                {
                                                        check=false;
                                                        break;
                                                }
                                                else
                                                {
                                                        check=true;
                                                }
                                        }
                                
                                      if(check==false)
                                      {
                                      break;
                                      }
                                    }
                                    

                                }
                                else if(pl1[4]<pl2[z] && pt1[4]>pt2[z])
                                {
                                   for(i=pl1[4],j=pt1[4];i<pl2[z];i+=80,j-=80)
                                   {
                                        for(n=0;n<=15;n++)
                                        {
                                                if((i==pl2[n] && j==pt2[n]) || (i==pl1[n] && j==pt1[n] && n!=4))
                                                {
                                                        check=false;
                                                        break;
                                                }
                                                else
                                                {
                                                        check=true;
                                                }
                                        }
                                
                                      if(check==false)
                                      {
                                      break;
                                      }
                                    }
                                    

                                }
                                else if(pl1[4]>pl2[z] && pt1[4]<pt2[z])
                                {
                                   for(i=pl1[4],j=pt1[4];i>pl2[z];i-=80,j+=80)
                                   {
                                        for(n=0;n<=15;n++)
                                        {
                                                if((i==pl2[n] && j==pt2[n]) || (i==pl1[n] && j==pt1[n] && n!=4))
                                                {
                                                        check=false;
                                                        break;
                                                }
                                                else
                                                {
                                                        check=true;
                                                }
                                        }
                                
                                      if(check==false)
                                      {
                                      break;
                                      }
                                    }
                                    

                                }


                   }

                 return check; 
        }
        boolean matebypiyada2(int z)
        {
                  if((pl2[z]-80==pl1[4] && pt2[z]-80==pt1[4]) || (pl2[z]+80==pl1[4] && pt2[z]-80==pt1[4]) )
                  {
                        
                                check=true;

                  }
                  else
                  {
                  check=false;
                  }

                        return check;
        }
        boolean mate1()
        {
                check=false;
                c1=false;
                c2=false;
                c3=false;
                c4=false;
                c5=false;
                c6=false;
                c7=false;
                c8=false;
                c1=matebyelephant1(0);
                c2=matebyelephant1(7);
                c3=matebyhourse1(1);
                c4=matebyhourse1(6);
                c5=matebycamal1(2);
                c6=matebycamal1(5);
                c7=matebyqueen1(3);
                for(j=8;j<=15;j++)
                {
                        switch(role[j%8])
                        {
                        case 'p':
                        c8=matebypiyada1(j);
                        break;

                        case 'e':
                        c8=matebyelephant1(j);
                        break;

                        case 'h':
                        c8=matebyhourse1(j);
                        break;

                        case 'c':
                        c8=matebycamal1(j);
                        break;

                        case 'q':
                        c8=matebyqueen1(j);
                        break;
                        }
                        if(c8==true)
                        {
                        break;
                        }
                }
                if(c1==true||c2==true||c3==true||c4==true||c5==true||c6==true||c7==true||c8==true)
                {
                return true;
                }
                else
                {
                return false;
                }
                
        }
        boolean mate2()
        {
                check=false;
                c1=false;
                c2=false;
                c3=false;
                c4=false;
                c5=false;
                c6=false;
                c7=false;
                c8=false;
                
                c1=matebyelephant2(0);
                c2=matebyelephant2(7);
                c3=matebyhourse2(1);
                c4=matebyhourse2(6);
                c5=matebycamal2(2);
                c6=matebycamal2(5);
                c7=matebyqueen2(3);
                for(j=8;j<=15;j++)
                {
                        switch(role[j])
                        {
                        case 'p':
                        c8=matebypiyada2(j);
                        break;

                        case 'e':
                        c8=matebyelephant2(j);
                        break;

                        case 'h':
                        c8=matebyhourse2(j);
                        break;

                        case 'c':
                        c8=matebycamal2(j);
                        break;

                        case 'q':
                        c8=matebyqueen2(j);
                        break;
                        }
                        if(c8==true)
                        {
                        break;
                        }

                }
                if(c1==true||c2==true||c3==true||c4==true||c5==true||c6==true||c7==true||c8==true)
                {
                return true;
                }
                else
                {
                return false;
                }

                
        }

 	//3 method to display message for wrong move

	void wrongselectcheck()	
        {      
				undo();
                repaint();
                m=new mymessage("","wrong selection,check ccurs");
                m.setVisible(true);
                m.setSize(300,250);
        }      
                                          
	 void wrongcheck()
	  {
             c=0;
             m=new mymessage("my chess","Check");
             m.setVisible(true);
             m.setSize(300,250);
          }

         void wrongselection()
         {
                c=0;
                m=new mymessage("my chess","wrong selection");
                m.setVisible(true);
                m.setSize(300,250);
         }

         void backup()
         {
         for(i=0;i<=15;i++)
         {
         backl1[i]=pl1[i];
         backl2[i]=pl2[i];
         backt1[i]=pt1[i];
         backt2[i]=pt2[i];
         }
         }

         void undo()
         {
         for(i=0;i<=15;i++)
         {
         pl1[i]=backl1[i];
         pl2[i]=backl2[i];
         pt1[i]=backt1[i];
         pt2[i]=backt2[i];
         }

         }
}
