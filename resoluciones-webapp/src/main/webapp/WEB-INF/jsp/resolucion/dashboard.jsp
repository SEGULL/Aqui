<%@ include file="/WEB-INF/jsp/include/taglibs.jsp"%>


<display:table name="${listResolucion}" id="resolucion"
	requestURI="/dashboard" class="table">


	<display:column title="Nombre" property="nombre" />

	<display:column title="accion">
		<a href="../resolucion/${resolucion.id}">Editar</a>
		<a href="../resolucion/${resolucion.id}/items">Items</a>
	</display:column>
</display:table>

<br>
<br>
<a class="btn btn-primary" href="../resolucion/nuevo">Agregar</a>