
 <c:forEach  items="${ReturnList}" var="Return2">
 <c:forEach  items="${ReturnDetailList}" var="ReturnDetail2">
  <c:if test="${Return2.getReturn_id()==ReturnDetail2.getReturn_id()}" >
     <form action="deleteMember" method="post">
    <div class="modal fade" id="mydelete<c:out value="${Return2.getReturn_id()}"/>" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog modal-lg" role="document">
              <div class="modal-content">
                <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                  <h4 class="modal-title" id="myModalLabel">刪除退貨紀錄</h4>
                </div>
                <div class="modal-body">
                  <table class="table table-striped">
              <tbody>
              <input type="hidden" name="return_id" value="${Return2.getReturn_id()}">
                <tr>
                  <td><c:out value="${Return2.getReturn_id()}"/></td>
                  <td><c:out value="${Return2.getReturn_p_id()}"/></td>
                  <td><c:out value="${Return2.getP_amount()}"/></td>
                  <td><c:out value="${Return2.getReturn_M_id()}"/></td>
                  <td><c:out value="${Return2.getReturn_A_id()}"/></td>
                  <td><c:out value="${Return2.getReturn_total()}"/></td>
                </tr>
              </tbody>
            </table>
                </div>
                <div class="modal-footer">
                  <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                  <button type="submit"  name="type" value="deleteReturn" class="btn btn-primary">確認</button>
                </div>
              </div>
            </div>
          </div>
          </form>
          </c:if>
</c:forEach>
</c:forEach>


