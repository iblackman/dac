<%-- 
    Document   : FerramentasAdm
    Created on : 20/06/2017, 21:45:24
    Author     : caio
--%>

        <link rel="stylesheet" href="./CSS/estilo.css" type="text/css" /> 

        <%@include file="menu.jsp" %>

        <div id="submenu">

            <% // caso seja guest //// so pra deixar aqui, os UserTypes estao criados, 1-adm, 2-Host, 3-Guest***********ATENCAO
                int a = 3;
                // 0 = gest, 1 = host, 2 = adm
                if (a >= 0) {
                    out.print("<table><thead><tr><th>Participação</th></tr></thead>");
                    out.print("<tdoby>");
                    out.print("<tr><td><a href = \"criareventos.jsp\">DONE - Criar Eventos</a></td></tr>");
                    out.print("<tr><td><a href = \"listEventInsc\">DONE - Cancelar inscrição em Eventos</a></td></tr>");
                    out.print("<tr><td><a href = \"inscEmEventos\">ALMOST DONE -Inscrição em Eventos</a></td></tr>");
                    out.print("</tdoby></table>");
                }
                if (a >= 1) {
                    out.print("<table><thead><tr><th>Controle</th></tr></thead>");
                    out.print("<tdoby>");
                    out.print("<tr><td><a href = \"listEveDoHost\">ALMOST DONE - Controle de Inscritos</a></td></tr>");

                    out.print("</tdoby></table>");

                }
                if (a >= 2) {

                    out.print("<table><thead><tr><th>Aprovação</th></tr></thead>");
                    out.print("<tdoby>");
                    out.print("<tr><td><a href = \"ListarEventosWaitStatus\">DONE - Aprovação de Eventos</a></td></tr>");
                    out.print("<tr><td><a href = \"admRoom\">Salas</a></td></tr>");
                    out.print("</tdoby></table>");
                }
            %>







        </div>


        <%@include file="footer.jsp" %>
