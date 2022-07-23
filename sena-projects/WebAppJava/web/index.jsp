<%@page import="java.sql.ResultSet"%>
<%@page import="com.gamesmall.daos.PreguntaDao"%>
<%@page import="java.sql.Statement"%>
<%@page import="com.gamesmall.mysql.connection.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
    </head>
    <body>
        <div class='container'>
            <button class="btn btn-link"> Crear pregunta </button>
            <div id='questions' class='row'>


            </div>         
        </div>
        <script>
            let questions = null;
            $(document).ready(function () {
                getData();
            });
            const item = {
                password: $("#pwd").val(),
                isSecure: false
            };

            function deleteItem(id) {
                $.ajax({
                    url: "pregunta",
                    type: "DELETE",
                    success: function (result) {
                        console.log(result)
                    }
                });                    
            }
            function getData() {
                $.ajax({
                    type: "GET",
                    //accepts: "application/json",
                    url: "pregunta",
                    //contentType: "application/json",
                    error: function (jqXHR, textStatus, errorThrown) {
                        console.log(`${jqXHR}`, ` ${textStatus}`, ` ${errorThrown}`);
                    },
                    success: function (questions) {
                        for (question in questions) {
                            $("#questions").append("<div class='col-6' id='question-detail-" + questions[question].id + "'>" + questions[question].enunciado + "</div>");
                            $("#questions").append("<div class='col-2'>" + questions[question].valor + "</div>");
                            $("#questions").append(
                                $("<div class='col-2'></div>").append(
                                    $("<button>Editar</button>").on("click", function () {})
                                )
                            );
                            $("#questions").append(
                                $("<div class='col-2'></div>").append(
                                    $("<button>Borrar</button>").on("click", function () {
                                        deleteItem(questions[question].id);
                                    })
                                )
                            );

                        }
                    }
                });                
            }           
        </script>
    </body>
</html>
