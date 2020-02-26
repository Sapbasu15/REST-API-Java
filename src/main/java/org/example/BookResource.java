package org.example;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("Books")
public class BookResource {

    Library library = new Library();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(){
        return Response.ok(library.getAllBooks()).build();
    }

    @GET
    @Path("{bookId}")
    public Response getBook(@PathParam("bookId") int bookId){
        Book book = library.getBookById(bookId);
        Response response = null;
        if(book == null)
            response = Response.status(Response.Status.NOT_FOUND).entity("Cannot Find Book : "+bookId).build();
        else
            response = Response.ok(book, MediaType.APPLICATION_JSON).build();
        return response;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addBook(Book book){
        Book newBook = library.addBook(book);
        return Response.ok(newBook).build();
    }

    @DELETE
    @Path("{bookId}")
    public Response deleteBook(@PathParam("bookId") int id){
        boolean success = library.deleteBook(id);
        if (success)
            return Response.ok().build();
        else
            return Response.status(Response.Status.NOT_FOUND).entity("Book not deleted").build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(Book book){
        if (library.updateBook(book))
            return Response.ok().build();
        else
            return Response.status(Response.Status.NOT_FOUND).entity("book not found").build();
    }

}
