
<div class="container">
	<div class="row">
		<!-- TO display side bar -->
		<div class="col-md-3">
			<%@include file="./common/sidebar.jsp"%>
		</div>
		<!-- TO display actually products -->
		<div class="col-md-9">
			
			<div class="row">
				<div class="col-lg-12">
				<table id="productListTable"
						class="table table-striped table-borderd">
						<thead>
							<tr>
								<th></th>
								<th>Name</th>
								<th>Brand</th>
								<th>Price</th>
								<th>Quantity</th>
								<th></th>
							</tr>
						</thead>
						
						<tfoot>
							<tr>
								<th></th>
								<th>Name</th>
								<th>Brand</th>
								<th>Price</th>
								<th>Quantity</th>
								<th></th>
								
							</tr>
						</tfoot>

					</table>

				</div>
				
				

			</div>
			

			
		</div>

	</div>
	
	
</div>
<!-- Adding breadcrum component -->
					<%-- <c:if test="${userclickAllProducts==true}">
						<table>
							<tr>
								<td><a href="${contextRoot}/home">Home</a></td>
								<td>/<a class="active">AllProducts</a></td>
								<td></td>
							</tr>
						</table>

					</c:if>
					<c:if test="${userclickCategoryProducts==true}">
						<table>
							<tr>
								<td><a href="${contextRoot}/home">Home</a></td>
								<td>/<a class="active">AllProducts</a></td>
								<td><a class="active">/${category.name}</td>
							</tr>
						</table>
					</c:if> --%>