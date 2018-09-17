Date.prototype.addDays = function(days) {
    var date = new Date(this.valueOf());
    date.setDate(date.getDate() + days);
    return date;
}

Date.prototype.toFormatString = function() {
	 var date = new Date(this.valueOf());
	 
	 var dd = date.getDate();
	 var mm = date.getMonth() + 1;
	 var yyyy = date.getFullYear();

	 if(dd < 10){
		dd ='0'+ dd;
	 } 
	 
	 if(mm < 10){
		 mm ='0'+ mm;
	 } 

	 return yyyy + '-' + mm + '-' + dd;
}

function loadDateField(id, inicio, final) {
	document.getElementById(id).value = inicio;
	document.getElementById(id).setAttribute("min", inicio);
	
	if (final != null) {
		document.getElementById(id).setAttribute("max", final);
	}
}

function loadFechaVuelta() {
	var inicio = document.getElementById("fIda").value;
	loadDateField("fRegreso", inicio, null);
}

/**
 * Carga los vuelos
 */
var request = new XMLHttpRequest();
request.open('GET', '/evaluacion1/vuelo/retrieve', true);

request.onload = function() {
  if (request.status == 200) {
    var jsonList = JSON.parse(request.responseText);
    var selectItem = '<option selected value="">Seleccione...</option>';
    
    for (var i in jsonList) {
      var nombre = jsonList[i].nombre;
      var valor = jsonList[i].valor;
      selectItem += '<option value="' + valor + '">' + nombre + '</option>';
    }

    document.getElementById("vuelo").innerHTML = selectItem;

  } else {
    alert('Error al consultar los vuelos.');
  }
};

request.onerror = function() {
  alert('Error al consultar los vuelos.');
};

request.send();

$("#vuelo").change(function() {
	var e = document.getElementById("vuelo");
	var valor = e.options[e.selectedIndex].value;
	document.getElementById("precio").value = valor;
});

var minDate = new Date();
var maxDate = new Date();
minDate = minDate.addDays(30);
maxDate = maxDate.addDays(120);
loadDateField("fIda", minDate.toFormatString(), maxDate.toFormatString());

$("#ida").change(function() {
	var ida = document.getElementById("ida").value;
	
	if (ida) {
		document.getElementById("fechaRegreso").required = false;
		document.getElementById("fechaRegreso").className = 'rendered';
	}
});

$("#idaVuelta").change(function() {
	var ida = document.getElementById("idaVuelta").value;
	
	if (ida) {
		document.getElementById("fechaRegreso").className = 'form-group';
		document.getElementById("fechaRegreso").required = true;
		loadFechaVuelta();
		
		$("#fIda").change(function() {
			loadFechaVuelta();
		});
	}
});