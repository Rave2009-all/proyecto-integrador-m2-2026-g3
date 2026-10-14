package com.example;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.TabSheet;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("proyecto integrador grupo 3")
@Route("")
public class MainView extends VerticalLayout {

    public MainView() {
        setSizeFull();
        setPadding(true);
        setSpacing(true);

        H2 titulo = new H2("Bookly");

        TabSheet tabSheet = new TabSheet();
        tabSheet.setWidthFull();

        tabSheet.add("Usuarios", crearSeccionUsuarios());
        tabSheet.add("Reservas", crearSeccionReservas());
        tabSheet.add("Detalle Reserva", crearSeccionDetalleReserva());
        tabSheet.add("Libros", crearSeccionLibros());
        tabSheet.add("Editoriales", crearSeccionEditoriales());
        tabSheet.add("Categorias", crearSeccionCategorias());

        add(titulo, tabSheet);
    }

    private Component crearSeccionUsuarios() {
        VerticalLayout layout = new VerticalLayout();
        layout.setPadding(false);

        TextField usuarioIdField = new TextField("ID Usuario");
        TextField nombreUsuarioField = new TextField("Nombre Usuario");
        TextField emailUsuarioField = new TextField("Email Usuario");
        TextField tipoUsuarioField = new TextField("Tipo Usuario");

        FormLayout form = new FormLayout(usuarioIdField, nombreUsuarioField, emailUsuarioField,
                tipoUsuarioField);

        Button btnCrear = new Button("Crear",
                e -> Notification.show("Usuarios - Crear: " + nombreUsuarioField.getValue()));
        btnCrear.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        Button btnConsultar = new Button("Consultar",
                e -> Notification.show("Usuarios - Consultar ID: " + usuarioIdField.getValue()));

        Button btnActualizar = new Button("Actualizar",
                e -> Notification.show("Usuarios - Actualizar ID: " + usuarioIdField.getValue()));

        Button btnEliminar = new Button("Eliminar",
                e -> Notification.show("Usuarios - Eliminar ID: " + usuarioIdField.getValue()));
        btnEliminar.addThemeVariants(ButtonVariant.LUMO_ERROR);

        Button btnLimpiar = new Button("Limpiar", e -> {
            usuarioIdField.clear();
            nombreUsuarioField.clear();
            emailUsuarioField.clear();
            tipoUsuarioField.clear();
        });

        HorizontalLayout acciones = new HorizontalLayout(
                btnCrear, btnConsultar, btnActualizar, btnEliminar, btnLimpiar);
        acciones.getStyle().set("flex-wrap", "wrap");

        Grid<String[]> grid = new Grid<>();
        grid.addColumn(row -> row[0]).setHeader("ID Usuario").setAutoWidth(true);
        grid.addColumn(row -> row[1]).setHeader("Nombre Usuario").setAutoWidth(true);
        grid.addColumn(row -> row[2]).setHeader("Email Usuario").setAutoWidth(true);
        grid.addColumn(row -> row[3]).setHeader("Tipo Usuario").setAutoWidth(true);

        layout.add(form, acciones, grid);
        return layout;
    }

    private Component crearSeccionReservas() {
        VerticalLayout layout = new VerticalLayout();
        layout.setPadding(false);

        TextField reservaIdField = new TextField("ID Reserva");
        DatePicker fechaReservaField = new DatePicker("Fecha Reserva");
        TextField usuarioIdField = new TextField("ID Usuario");
        DatePicker fechaLimiteField = new DatePicker("Fecha Limite");
        TextField estadoField = new TextField("Estado");

        FormLayout form = new FormLayout(reservaIdField, fechaReservaField, usuarioIdField,
                fechaLimiteField, estadoField);

        Button btnCrear = new Button("Crear",
                e -> Notification.show("Reservas - Crear: " + usuarioIdField.getValue()));
        btnCrear.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        Button btnConsultar = new Button("Consultar",
                e -> Notification.show("Reservas - Consultar ID: " + reservaIdField.getValue()));

        Button btnActualizar = new Button("Actualizar",
                e -> Notification.show("Reservas - Actualizar ID: " + reservaIdField.getValue()));

        Button btnEliminar = new Button("Eliminar",
                e -> Notification.show("Reservas - Eliminar ID: " + reservaIdField.getValue()));
        btnEliminar.addThemeVariants(ButtonVariant.LUMO_ERROR);

        Button btnLimpiar = new Button("Limpiar", e -> {
            reservaIdField.clear();
            fechaReservaField.clear();
            usuarioIdField.clear();
            fechaLimiteField.clear();
            estadoField.clear();
        });

        HorizontalLayout acciones = new HorizontalLayout(
                btnCrear, btnConsultar, btnActualizar, btnEliminar, btnLimpiar);
        acciones.getStyle().set("flex-wrap", "wrap");

        Grid<String[]> grid = new Grid<>();
        grid.addColumn(row -> row[0]).setHeader("ID Reserva").setAutoWidth(true);
        grid.addColumn(row -> row[1]).setHeader("Fecha Reserva").setAutoWidth(true);
        grid.addColumn(row -> row[2]).setHeader("ID Usuario").setAutoWidth(true);
        grid.addColumn(row -> row[3]).setHeader("Fecha Limite").setAutoWidth(true);
        grid.addColumn(row -> row[4]).setHeader("Estado").setAutoWidth(true);

        layout.add(form, acciones, grid);
        return layout;
    }

    private Component crearSeccionDetalleReserva() {
        VerticalLayout layout = new VerticalLayout();
        layout.setPadding(false);

        TextField reservaIdField = new TextField("ID Reserva");
        TextField libroIdField = new TextField("ID Libro");
        NumberField cantidadField = new NumberField("Cantidad");
        TextArea notasField = new TextArea("Notas");

        FormLayout form = new FormLayout(reservaIdField, libroIdField, cantidadField, notasField);

        Button btnCrear = new Button("Crear",
                e -> Notification.show("Detalle Reserva - Crear: " + reservaIdField.getValue()));
        btnCrear.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        Button btnConsultar = new Button("Consultar",
                e -> Notification.show("Detalle Reserva - Consultar ID: "
                        + reservaIdField.getValue() + " / " + libroIdField.getValue()));

        Button btnActualizar = new Button("Actualizar",
                e -> Notification.show("Detalle Reserva - Actualizar ID: "
                        + reservaIdField.getValue() + " / " + libroIdField.getValue()));

        Button btnEliminar = new Button("Eliminar",
                e -> Notification.show("Detalle Reserva - Eliminar ID: "
                        + reservaIdField.getValue() + " / " + libroIdField.getValue()));
        btnEliminar.addThemeVariants(ButtonVariant.LUMO_ERROR);

        Button btnLimpiar = new Button("Limpiar", e -> {
            reservaIdField.clear();
            libroIdField.clear();
            cantidadField.clear();
            notasField.clear();
        });

        HorizontalLayout acciones = new HorizontalLayout(
                btnCrear, btnConsultar, btnActualizar, btnEliminar, btnLimpiar);
        acciones.getStyle().set("flex-wrap", "wrap");

        Grid<String[]> grid = new Grid<>();
        grid.addColumn(row -> row[0]).setHeader("ID Reserva").setAutoWidth(true);
        grid.addColumn(row -> row[1]).setHeader("ID Libro").setAutoWidth(true);
        grid.addColumn(row -> row[2]).setHeader("Cantidad").setAutoWidth(true);
        grid.addColumn(row -> row[3]).setHeader("Notas").setAutoWidth(true);

        layout.add(form, acciones, grid);
        return layout;
    }

    private Component crearSeccionLibros() {
        VerticalLayout layout = new VerticalLayout();
        layout.setPadding(false);

        TextField libroIdField = new TextField("ID Libro");
        TextField tituloField = new TextField("Titulo");
        TextField autorField = new TextField("Autor");
        TextField editorialIdField = new TextField("ID Editorial");
        TextField categoriaIdField = new TextField("ID Categoria");

        FormLayout form = new FormLayout(libroIdField, tituloField, autorField,
                editorialIdField, categoriaIdField);

        Button btnCrear = new Button("Crear",
                e -> Notification.show("Libros - Crear: " + tituloField.getValue()));
        btnCrear.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        Button btnConsultar = new Button("Consultar",
                e -> Notification.show("Libros - Consultar ID: " + libroIdField.getValue()));

        Button btnActualizar = new Button("Actualizar",
                e -> Notification.show("Libros - Actualizar ID: " + libroIdField.getValue()));

        Button btnEliminar = new Button("Eliminar",
                e -> Notification.show("Libros - Eliminar ID: " + libroIdField.getValue()));
        btnEliminar.addThemeVariants(ButtonVariant.LUMO_ERROR);

        Button btnLimpiar = new Button("Limpiar", e -> {
            libroIdField.clear();
            tituloField.clear();
            autorField.clear();
            editorialIdField.clear();
            categoriaIdField.clear();
        });

        HorizontalLayout acciones = new HorizontalLayout(
                btnCrear, btnConsultar, btnActualizar, btnEliminar, btnLimpiar);
        acciones.getStyle().set("flex-wrap", "wrap");

        Grid<String[]> grid = new Grid<>();
        grid.addColumn(row -> row[0]).setHeader("ID Libro").setAutoWidth(true);
        grid.addColumn(row -> row[1]).setHeader("Titulo").setAutoWidth(true);
        grid.addColumn(row -> row[2]).setHeader("Autor").setAutoWidth(true);
        grid.addColumn(row -> row[3]).setHeader("ID Editorial").setAutoWidth(true);
        grid.addColumn(row -> row[4]).setHeader("ID Categoria").setAutoWidth(true);

        layout.add(form, acciones, grid);
        return layout;
    }

    private Component crearSeccionEditoriales() {
        VerticalLayout layout = new VerticalLayout();
        layout.setPadding(false);

        TextField editorialIdField = new TextField("ID Editorial");
        TextField nombreEditorialField = new TextField("Nombre Editorial");

        FormLayout form = new FormLayout(editorialIdField, nombreEditorialField);

        Button btnCrear = new Button("Crear",
                e -> Notification.show("Editoriales - Crear: " + nombreEditorialField.getValue()));
        btnCrear.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        Button btnConsultar = new Button("Consultar",
                e -> Notification.show("Editoriales - Consultar ID: " + editorialIdField.getValue()));

        Button btnActualizar = new Button("Actualizar",
                e -> Notification.show("Editoriales - Actualizar ID: " + editorialIdField.getValue()));

        Button btnEliminar = new Button("Eliminar",
                e -> Notification.show("Editoriales - Eliminar ID: " + editorialIdField.getValue()));
        btnEliminar.addThemeVariants(ButtonVariant.LUMO_ERROR);

        Button btnLimpiar = new Button("Limpiar", e -> {
            editorialIdField.clear();
            nombreEditorialField.clear();
        });

        HorizontalLayout acciones = new HorizontalLayout(
                btnCrear, btnConsultar, btnActualizar, btnEliminar, btnLimpiar);
        acciones.getStyle().set("flex-wrap", "wrap");

        Grid<String[]> grid = new Grid<>();
        grid.addColumn(row -> row[0]).setHeader("ID Editorial").setAutoWidth(true);
        grid.addColumn(row -> row[1]).setHeader("Nombre Editorial").setAutoWidth(true);

        layout.add(form, acciones, grid);
        return layout;
    }

    private Component crearSeccionCategorias() {
        VerticalLayout layout = new VerticalLayout();
        layout.setPadding(false);

        TextField categoriaIdField = new TextField("ID Categoria");
        TextField nombreCategoriaField = new TextField("Nombre Categoria");

        FormLayout form = new FormLayout(categoriaIdField, nombreCategoriaField);

        Button btnCrear = new Button("Crear",
                e -> Notification.show("Categorias - Crear: " + nombreCategoriaField.getValue()));
        btnCrear.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        Button btnConsultar = new Button("Consultar",
                e -> Notification.show("Categorias - Consultar ID: " + categoriaIdField.getValue()));

        Button btnActualizar = new Button("Actualizar",
                e -> Notification.show("Categorias - Actualizar ID: " + categoriaIdField.getValue()));

        Button btnEliminar = new Button("Eliminar",
                e -> Notification.show("Categorias - Eliminar ID: " + categoriaIdField.getValue()));
        btnEliminar.addThemeVariants(ButtonVariant.LUMO_ERROR);

        Button btnLimpiar = new Button("Limpiar", e -> {
            categoriaIdField.clear();
            nombreCategoriaField.clear();
        });

        HorizontalLayout acciones = new HorizontalLayout(
                btnCrear, btnConsultar, btnActualizar, btnEliminar, btnLimpiar);
        acciones.getStyle().set("flex-wrap", "wrap");

        Grid<String[]> grid = new Grid<>();
        grid.addColumn(row -> row[0]).setHeader("ID Categoria").setAutoWidth(true);
        grid.addColumn(row -> row[1]).setHeader("Nombre Categoria").setAutoWidth(true);

        layout.add(form, acciones, grid);
        return layout;
    }
}