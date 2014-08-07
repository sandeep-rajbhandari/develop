/**
 * Created by srajbhandari on 2/12/14.
 */
//$(document).ready(function(){
//    $("p").hide();
//
//    $("h1").click(function() {
//        $(this).next().slideToggle(3);
//    });
//
//
//});
$(function(){
    //alert($('#celebs tbody tr').length+"elements")
//    var fontsize=$('#celebs tr:first').css('font-size')
//    alert("font size"+fontsize)
    $('#celebs tbody tr:even').css({'background-color':'lightblue','color':'green'} )
    $('#toggleButton').click(function() {
        $('#information').toggle();
    if($('#information').is(':visible')){
        $(this).val('hide')    }
    else{
        $(this).val('show')
    }
})
})



