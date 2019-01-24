$(document).ready(function() {
	$("#tva").on("keyup", function () {
		tvaKayUpFunction();
	});
});

tvaKayUpFunction=function(){
	
	var prixUnitHT=$("#prixUnitaireHT").val();
	var tauxTva=$("#tva").val();
	var prixUnitaireTTC=parseFloat(parseFloat(prixUnitHT)*parseFloat(tauxTva)/100+parseFloat(prixUnitHT));
	$("#prixUnitaireTTC").val(prixUnitaireTTC);
	
	
	
}