var Fn = {
	loadCodigo : function() {
		var busqueda = document.getElementById("busqueda");
		busqueda.setAttribute("type", "number");
		busqueda.setAttribute("placeholder", "Ingrese código");
		busqueda.setAttribute("max", "99999");
		busqueda.setAttribute("min", "0");
		busqueda.setAttribute("maxlength", "5");
		busqueda.setAttribute("size", "5");
		busqueda.value = "";
	},
	loadNombre : function() {
		var busqueda = document.getElementById("busqueda");
		busqueda.setAttribute("type", "text");
		busqueda.setAttribute("placeholder", "Ingrese nombre");
		busqueda.removeAttribute("max");
		busqueda.removeAttribute("min");
		busqueda.removeAttribute("maxlength");
		busqueda.removeAttribute("size");
		busqueda.value = "";
	}
}

Fn.loadCodigo();

$("#tipoBusqueda").change(function(){
	var e = document.getElementById("tipoBusqueda");
	var tipoBusqueda = e.options[e.selectedIndex].value;
	
	if (tipoBusqueda == 'porCodigo') {
		Fn.loadCodigo();
	} else {
		Fn.loadNombre();
	}

});