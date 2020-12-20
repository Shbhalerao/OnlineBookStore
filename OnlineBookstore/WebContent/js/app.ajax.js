$(document).ready(function(){

   $("button").click(function(e){
    e.preventDefault();
    
var countrycode=pareseInt($(this).val());
alert("hello:::"+countrycode);

$.ajax({

url:"demoJsonServlet?countrycode="+countrycode,
type:"get",
data:countrycode,
dataType:"json",

success:function(data,textStatus,jqXHR){

if(data.success){
alert("hhhh");



$("#templatemo content right").html("");
alert("down111");

$("#templatemo content right").append("<p>"+data.countryInfo.bookId+"</p>");
$("#templatemo content right").append("<h3>bookName:</b>"+data.countryInfo.bookName+"</h3></br>");
$("#templatemo content right").append("<h3>author:</b>"+data.countryInfo.author+"</br>");
}
}

});
});
});








