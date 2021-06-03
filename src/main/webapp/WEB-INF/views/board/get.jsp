<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../includes/header.jsp" %>

            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">글 조회</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            글 조회 페이지
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="form-group">
                                <label>Bno</label>
                                <input class="form-control" name="bno" value='<c:out value="${board.bno}"/>' readonly="readonly">
                            </div>
                            <div class="form-group">
                                <label>Title</label>
                                <input class="form-control" name="title" value='<c:out value="${board.title}"/>' readonly="readonly">
                            </div>
                            <div class="form-group">
                                <label>Text Area</label>
                                <textarea class="form-control" rows="3" name="content" readonly="readonly"><c:out value="${board.content}"/></textarea>
                            </div>
                            <div class="form-group">
                                <label>Writer</label>
                                <input class="form-control" name="writer" value='<c:out value="${board.writer}"/>' readonly="readonly">
                            </div>
                                <button type="submit" data-oper="modify" class="btn btn-default">수정하기</button>
                                <button type="submit" data-oper="list" class="btn btn-info">돌아가기</button>

                                <form id="operForm" action="/board/modify" method="get">
                                    <input type="hidden" id="bno" name="bno" value='<c:out value="${board.bno}"/>'>
                                    <input type="hidden" id="bno" name="pageNum" value='<c:out value="${criteria.pageNum}"/>'>
                                    <input type="hidden" id="bno" name="amount" value='<c:out value="${criteria.amount}"/>'>
                                </form>
                            </form>
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
    <script type="text/javascript" charset="utf-8">
        $(document).ready(function() {
            var operForm = $('#operForm');
            $("button[data-oper='modify']").on('click', function(e) {
                operForm.attr('action', '/board/modify').submit();
            });
            $("button[data-oper='list']").on('click', function(e) {
                operForm.find('#bno').remove();
                operForm.attr('action', '/board/list');
                operForm.submit();
            });
        });
    </script>
<%@ include file="../includes/footer.jsp" %>
