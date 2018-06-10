<div class="container">

	<div class="row">
		<div class="col-xs-12">
			<ol class="breadcrumb">
				<li><a href="${contextRoot}/home">home</a></li>
				<li><a href="${contextRoot}/show/all/products">Products</a></li>
				<li><a class="active">${product.name}</a></li>
			</ol>
		</div>
	</div>

	<div class="row">
		<!-- DIsplay Image here-- -->
		
		<div class="col-xs-12 col-sm-4">
			<div class="thumbnail">
				<img src="${images}/${product.code}.jpg" class="img img-resposive imageSingleProduct" />
			</div>
		</div>

		<!-- DIsplay desription here -- -->
		<div class="col-xs-12 col-sm-8">

			<h3>${product.name}</h3>
			<hr />
			<p>${product.description}</p>
			<hr />

			<h4>
				Price: <string>&#8377 ${product.unitPrice}</string>
			</h4>
			<h6>Qty. Available: ${product.quantity}</h6>
     		<!-- Out Of Stock code  -->
			<c:choose>
				<c:when test="${product.quantity <1}">
					<h6>Qty. Available: <span style="color: red;">Out of Stock</span>
					<hr/>
					<a href="javascript:void(0)" class="btn btn-success disabled"><strike><span class="glyphicon glyphicon-shopping-cart"> Add to Cart</span></strike></a> 
				<a	href="${contextRoot}/show/all/products" class="btn btn-primary"><span class="glyphicon glyphicon-shopping-cart">Back</span></a>
					
					</h6>
					
				</c:when>
				<c:otherwise>
					<h6>Qty. Available: ${product.quantity}</h6>
					<a href="${contextRoot}/cart/add/${product.id}/product" class="btn btn-success"> <span class="glyphicon glyphicon-shopping-cart"> Add to Cart</span></a> 
				<a	href="${contextRoot}/show/all/products" class="btn btn-primary"><span class="glyphicon glyphicon-shopping-cart">Back</span></a>
										
				</c:otherwise>
			</c:choose>
			<!-- Out Of Stock code  -->
			
		</div>
			 
	</div>

</div>