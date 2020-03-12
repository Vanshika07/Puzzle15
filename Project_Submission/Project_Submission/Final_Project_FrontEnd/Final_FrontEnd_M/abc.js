var sd;
$('document').ready(function(){
    sd=document.getElementById("s1").value;
    
    
});
$('document').ready(function f(){
    $("#loading").css({"transform":"rotate("+deg+"deg)"});
    deg=deg+10;
    setTimeout(f,500);
    
});

var deg=10;
var bl;
var kk=0;
var c;
var ar;
function out(res2)
{

    var res1=res2.split("&")[1];
    var res=res2.split("&")[0];
   var char=res.split(",");
   var map=['U','D','R','L'];
   var r=[-1,1,0,0];
   var c=[0,0,1,-1];
   var l=char.length;
 document.getElementById("st").value=char.length;
 document.getElementById("o1").value=res;
 document.getElementById("tim").value=res1;
 sd=document.getElementById("s1").value;
 ar=char;
 mv();
}

var ii,jj;
function mv(){
   
    
    var r=[-1,1,0,0];
    var c=[0,0,1,-1];
if(parseInt(kk)<ar.length){
    
    if(ar[kk]=='U')
    {
       ii=r[0];
       jj=c[0];
    }
    if(ar[kk]=='D')
    {
        ii=r[1];
       jj=c[1];
    }
    if(ar[kk]=='R')
    {
        ii=r[2];
       jj=c[2];
    }
    if(ar[kk]=='L')
    {
        ii=r[3];
       jj=c[3];
    }
   
            var di=bl.split(",");
            var newC=di[0]+di[1];
            var newX=parseInt(di[0].trim())+ii;
            var newY=parseInt(di[1].trim())+jj;
            var Nz=newX+"" + newY+"";
            var interVal=document.getElementById(Nz).innerHTML;
            document.getElementById(newC).innerHTML=interVal;
            document.getElementById(Nz).innerHTML="";
            document.getElementById(Nz).style.backgroundColor="lightgray";
            document.getElementById(newC).style.backgroundColor="peru";
          bl=newX+","+newY;
          kk=parseInt(kk)+1;
          
setTimeout(mv, 2000 * parseInt(sd));
}
else{
    console.log("else");
    con();
}
}
function con()
{
    
    $('.hover_bkgr_fricc').show();
    $('.hover_bkgr_fricc').click(function(){
        $('.hover_bkgr_fricc').hide();
    });
    $('.popupCloseButton').click(function(){
        $('.hover_bkgr_fricc').hide();
    });
}

var res;
   function inp()
   {
       var x,y;
       var t;
    var i=document.getElementById("ll").value;
     var ar=i.split(",");
     var inn=ar.join("");
       var arr=inn.split(" ");
       document.getElementById("33").style.backgroundColor="#52030d";
       for(k=0;k<16;k++)
       {
        
			if(k==0) {
				x=0;y=0;
			}
			else if(k==4){
				x=1;y=0;
			}
			else if(k==8){
				x=2;y=0;
			}
			else if(k==12){
				x=3;y=0;
            }
            t=x+""+y;
            if(arr[k]!=0)
            {
            document.getElementById(t).innerHTML=arr[k];
            }
            else{
                document.getElementById(t).innerHTML="";
            }
			
			y++;
		
           if(arr[k]=="0")
           {
               var ii= Math.floor(k/4);
               var jj=k%4;
               bl=ii+","+jj;
           }
       }
       $(document).ready(function() {
        $.get("http://localhost:8080/PuzzleSollution/"+inn,function(data){
            res=data;
            out(res);


            
        })
    })
     
   }
   

