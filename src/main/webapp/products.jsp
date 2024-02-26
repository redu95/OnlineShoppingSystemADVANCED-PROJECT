<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.connection.*"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Online Shopping System</title>
        <!-- Importing all ui libs -->
        <link href="assets/css/font-awesome.css" rel="stylesheet" />
        <link href="assets/css/style.css" rel="stylesheet" />
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
        <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
        <script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
        <script src="js/simpleCart.min.js"></script>
        <script type="text/javascript" src="js/bootstrap-3.1.1.min.js"></script>
        <link href='http://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Lato:400,100,100italic,300,300italic,400italic,700,900,900italic,700italic' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
        <script src="js/jquery.easing.min.js"></script>
        <script src='../../../../../../ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js'></script>
        <script src="../../../../../../m.servedby-buysellads.com/monetization.js" type="text/javascript"></script>
    </head>
    <body>
    <body>
        <div class="ban-top">
            <div class="container">
                <div class="top_nav_left">
                    <nav class="navbar navbar-default">
                        <div class="container-fluid">
                            <div class="navbar-header">
                                <button type="button" class="navbar-toggle collapsed"
                                        data-toggle="collapse"
                                        data-target="#bs-example-navbar-collapse-1"
                                        aria-expanded="false">
                                    <span class="sr-only">Toggle navigation</span> <span
                                        class="icon-bar"></span> <span class="icon-bar"></span> <span
                                        class="icon-bar"></span>
                                </button>
                            </div>
                            <jsp:include page="header.jsp"></jsp:include>
                            </div>
                        </nav>
                    </div>

                    <div class="top_nav_right">
                        <div class="cart box_1">
                            <a href="checkout.jsp"> 
                            <%
                                ResultSet resultCount = DatabaseConnection.getResultFromSqlQuery("select count(*) from tblcart where customer_id='" + session.getAttribute("id") + "'");
                                resultCount.next();
                                int count = resultCount.getInt(1);
                            %>
                            <h3>
                                <div class="total">
                                    <i class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></i>
                                    (
                                    <%=count%>
                                    items )
                                </div>

                            </h3>
                        </a>
                        <p>
                            <a href="javascript:;" class="simpleCart_empty">My Cart</a>
                        </p>
                    </div>
                </div>
                <div class="clearfix"></div>
            </div>
        </div>	
        <div class="electronics">
            <div class="container">
                <div class="clearfix"></div>
                <div class="ele-bottom-grid">
                    <h3>Search Results</h3>

                    <%
                        String searchQuery = request.getParameter("productName");

                        if (searchQuery != null && !searchQuery.isEmpty()) {
                            // If a search query is provided, display the searched products
                            String searchSqlQuery = "select * from tblproduct where name like '%" + searchQuery + "%'";
                            ResultSet searchResults = DatabaseConnection.getResultFromSqlQuery(searchSqlQuery);

                            while (searchResults.next()) {
                    %>
                    <form action="AddToCart" method="post">
				        <div class="search-result">
				            <div class="col-md-3 product-men">
				                <div class="men-pro-item simpleCart_shelfItem">
				                    <div class="men-thumb-item">
				                        <input type="hidden" name="productId" value="<%= searchResults.getInt("id") %>">
				                        <img src="uploads/<%= searchResults.getString("image_name") %>" alt="" class="pro-image-front">
				                        <img src="uploads/<%= searchResults.getString("image_name") %>" alt="" class="pro-image-back">
				                        <span class="product-new-top">New</span>
				                    </div>
				                    <div class="item-info-product">
				                        <h4><%= searchResults.getString("name") %></h4>
				                        <h5>Category: <%= searchResults.getString("product_category") %></h5>
				                        <div class="info-product-price">
				                            <input type="hidden" name="price" value="<%= searchResults.getString("price") %>">
				                            <input type="hidden" name="mrp_price" value="<%= searchResults.getString("mrp_price") %>">
				                            <span class="item_price"><%= searchResults.getString("price") %> ETB.</span>
				                            <del><%= searchResults.getString("mrp_price") %> ETB.</del>
				                        </div>
				                     
				                        <input type="submit" value="Add to cart" class="btn btn-warning" onclick="return confirm('Are you sure you want to add this item to the cart?');">
				                    </div>
				                </div>
				            </div>
				        </div>
				    </form>
                    <%
                            }
                        }
                    %>
                </div>
                
                <div class="ele-bottom-grid">
                    <h3>
                        Our Products
                    </h3>
                    <%
                    
                        ResultSet retriveProduct = DatabaseConnection.getResultFromSqlQuery("select * from tblproduct");
                        while (retriveProduct.next()) {
                    %>
                    <form action="AddToCart" method="post">
                        <div class="col-md-3 product-men">
                            <div class="men-pro-item simpleCart_shelfItem">
                                <div class="men-thumb-item">
                                    <input type="hidden" name="productId" value="<%=retriveProduct.getInt("id")%>">
                                    <img src="uploads/<%=retriveProduct.getString("image_name")%>" alt="" class="pro-image-front">
                                    <img src="uploads/<%=retriveProduct.getString("image_name")%>" alt="" class="pro-image-back"> <span class="product-new-top">New</span>
                                </div>
                                <div class="item-info-product ">
                                    <h4>
                                        <%=retriveProduct.getString("name")%>
                                    </h4>
                                    <h5>
                                        Category: <%=retriveProduct.getString("product_category")%>
                                    </h5>
                                    <div class="info-product-price">
                                        <input type="hidden" name="price" value="<%=retriveProduct.getString("price")%>"> 
                                        <input type="hidden" name="mrp_price" value="<%=retriveProduct.getString("mrp_price")%>"> <span class="item_price"><%=retriveProduct.getString("price")%> ETB.</span>
                                        <del><%=retriveProduct.getString("mrp_price")%> ETB.</del>
                                    </div>
                                    <input type="submit" value="Add to cart" class="btn btn-warning" onclick="return confirm('Are you sure Do you want to add this item in cart?');">
                                </div>
                            </div>
                        </div>
                    </form>
                    <%
                        }
                    %>
                </div>
            </div>
        </div>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>