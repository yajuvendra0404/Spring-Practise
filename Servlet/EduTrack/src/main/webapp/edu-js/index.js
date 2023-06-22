

        $(document).ready(function () {
            $("#form").kendoForm({
                formData: {
                    FirstName: "",
                    LastName: "",
                    Email: "",
                    Password: "",
                    Birth: new Date(),
                    Agree: false
                },
                layout: "grid",
                grid: {
                    cols: 2,
                    gutter: 20
                },
                items: [
                    {
                        type: "group",
                        label: "Personal Information",
                        items: [
                            { 
                                field: "FirstName", 
                                label: "First Name:", 
                                validation: { required: true } 
                            },
                            { 
                                field: "LastName", 
                                label: "Last Name:", 
                                validation: { required: true } 
                            },
                            { 
                                field: "Email", 
                                label: "Email", 
                                validation: { 
                                    required: true, 
                                    email: true 
                                }
                            },
                            { 
                                field: "Password", 
                                label: "Password:", 
                                validation: { required: true }, 
                                hint: "Hint: enter alphanumeric characters only." 
                            },
                            { 
                                field: "Birth", 
                                label: { text: "Date of birth:", optional: true } 
                            }
                        ]
                    },
                    {
                        type: "group",
                        label: "Shipping Address",
                        layout: "grid",
                        grid: { cols: 2, gutter: 10 },                          
                        items: [
                            { 
                                field: "Country", 
                                editor: "DropDownList", 
                                label: "Country", 
                                validation: { required: true }, 
                                colSpan: 1,
                                editorOptions: {
                                    optionLabel: "Select country...",
                                    dataSource: [
                                        { Name: "France", Id: 1 },
                                        { Name: "Germany", Id: 2 },
                                        { Name: "Italy", Id: 3 },
                                        { Name: "Spain", Id: 4 }
                                    ],
                                    dataTextField: "Name",
                                    dataValueField: "Id"
                                }
                            },
                            { 
                                field: "City", 
                                label: "City", 
                                validation: { required: true },
                                colSpan: 1,
                            },
                            { 
                                field: "AddressLine", 
                                label: "Address Line", 
                                colSpan: 2,
                                validation: { required: true } 
                            },
                        ]
                    },
                    { 
                        field: "Agree", 
                        label: "Agree to Terms", 
                        validation: { required: true } 
                    }
                ]
            });
        });
