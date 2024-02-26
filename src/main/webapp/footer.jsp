<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!-- Defining Footer -->
<div class="coupons">
    <div class="container">
        <div class="coupons-grids text-center">
            <div class="col-md-3 coupons-gd">
                <h3>Simple Steps to buy online</h3>
            </div>
            <div class="col-md-3 coupons-gd">
                <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
                <h4>LOGIN TO YOUR ACCOUNT</h4>
            </div>
            <div class="col-md-3 coupons-gd">
                <span class="glyphicon glyphicon-ok" aria-hidden="true"></span>
                <h4>SELECT YOUR ITEM</h4>	
            </div>
            <div class="col-md-3 coupons-gd">
                <span class="glyphicon glyphicon-credit-card" aria-hidden="true"></span>
                <h4>MAKE PAYMENT</h4>
            </div>
            <div class="clearfix"></div>
        </div>
    </div>
</div>
<section class="footer-section">
    <div class="row">
        <div class="col">
            <div class="sign-grds">
                <div class="col-md-3 sign-gd-two">
                    <h4 style="text-align: left;">Contact Us:</h4>
                    <ul style="text-align: left;">
                        <li><i class="glyphicon glyphicon-map-marker" aria-hidden="true"></i>Address : Adama, <span>Ethiopia.</span></li>
                        <li><i class="glyphicon glyphicon-envelope" aria-hidden="true"></i>Email : <a href="mailto:redietmuluken95@gmail.com">redietmuluken95@gmail.com</a></li>
                        <li><i class="glyphicon glyphicon-earphone" aria-hidden="true"></i>Phone : +251-941-626-739</li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="col">
            <br/><br/><br/>
            <center>
                <div class="container">
                    <h4>
                        &copy;  <span id="year"></span> Project - Online Shopping System |<a href="https://data-flair.training" target="_blank"> Designed by : ASTU</a>
                    </h4>
                </div>
            </center>
        </div>
    </div>
</section>
<script>
    document.getElementById("year").innerHTML = new Date().getFullYear();
</script>