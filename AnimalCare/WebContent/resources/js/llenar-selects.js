/**
 * Llenar selects con jquery
 */

lista = {

	listaPaises : null,
	listaDeps : null,
	listaCiudades : null,

	init : function() {
		lista.pais();
		lista.configurarEventos();
	},

	configurarEventos : function() {
		$('#sel-pais').change(function() {
			$('#sel-dep').empty();
			$('#sel-ciudad').empty();
			lista.dep();
		});

		$('#sel-dep').change(function() {
			$('#sel-ciudad').empty();
			lista.ciudad();
		});
	},

	pais : function() {
		lista.listaDeps = new Array();

		$.get('PaisController', function(response) {
			var arr = new Array();
			var respuesta = new Array();
			respuesta = lista.arrayResponse(response, arr);

			$.each(respuesta, function(index, value) {
				$("#sel-pais").append(
						$('<option></option>').attr('value', value.id).text(
								value.nombre));
				lista.listaDeps[value.id] = value.mdsDepartamentos;
			});
		}).fail(function(response) {
			alert(response.responseText);
		});
	},

	dep : function() {
		lista.listaCiudades = new Array();
		var codigo = $('#sel-pais').val();
		var departamentos = lista.listaDeps[codigo];

		$("#sel-dep").append(
				$('<option></option>').attr('value', 0).text(
						"Seleccione un departamento..."));

		$.each(departamentos, function(index, value) {
			$("#sel-dep").append(
					$('<option></option>').attr('value', value.id).text(
							value.nombre));
			lista.listaCiudades[value.id] = value.mdsCiudades;
		});

	},

	ciudad : function() {

		var codigo = $('#sel-dep').val();
		var ciudades = lista.listaCiudades[codigo];

		$("#sel-ciudad").append(
				$('<option></option>').attr('value', 0).text(
						"Seleccione una ciudad..."));
		
		$.each(ciudades, function(index, value) {
			$("#sel-ciudad").append(
					$('<option></option>').attr('value', value.id).text(
							value.nombre));
		});
	},

	arrayResponse : function(rs, arr) {
		// Quitar anidamientos 0x1
		for (var i = 0; i < rs.length; i++) {
			if (rs[i]["0x1"]) {
				var dato = rs[i]["0x1"];
				arr.push(dato);
			} else {
				arr.push(rs[i]);
			}
		}
		return arr;
	}

}