<%--
  Created by IntelliJ IDEA.
  User: endo
  Date: 8/30/2017
  Time: 3:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>

    <meta name="viewport" content="width= device-width" ,
          initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <title>My Google Map</title>
    <style>

        #map {
            height: 400px;
            width: 100%;
        }
    </style>

</head>

<body>

<div id="map"></div>

<script>

    function initMap() {

        // Map options
        var options = {
            center: {lat: 42.331429, long: -83.045753},
            zoom: 8


        };
        // New map
        var map = maps.Map(document.getElementById('map',options));

        addMarker({lat:42.356657,lng: -83.064209});
        addMarker({lat:42.356657,lng: -83.064209});
        addMarker({lat:42.356657,lng: -83.064209});
        addMarker({lat:42.356657,lng: -83.064209});
        addMarker({lat:42.356657,lng: -83.064209});
        // Array of markers

        var markers = [


        ];

        // Add marker function
        function addMarker(props) {
            var marker = new google.maps.Marker({


                position: props,coords,
                map: map
               // icon: 'https://developers.google.com/maps/documentation/javascript/examples/full/images/beachflag.png'


            });

            //check for customicon
            if(props.iconImage){
                // set iconImage
                marker.setIcon(props.iconImage);
            }

            // check content
            if (props.content){

                var  infoWindow = new google.maps.infoWindow({
                    content:props.content
                });

                marker.addListener('click', function () {
                    infoWindow.open(map, marker);

                })


            }
        }
    }

</script>


<script async defer
        src="https://maps.googleapis.com/maps/api/is?key=AIzaSyBrgAsck66IK0Yi-Kjjw2gay8660pNldW8&callback=initMap">
</script>
<script>


</script>


</body>
</html>
