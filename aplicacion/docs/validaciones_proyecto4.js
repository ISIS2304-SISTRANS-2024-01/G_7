//Clientes
{
  $jsonSchema: {
    bsonType: 'object',
    required: [
      'tipo_cliente',
      'nombre',
      'apellido',
      'numero_identificacion',
      'tipo_identificacion',
      'login',
      'clave',
      'nacionalidad',
      'direccion',
      'correo',
      'celular',
      'ciudad',
      'departamento',
      'codigo_postal',
      'cuenta'
    ],
    properties: {
      tipo_cliente: {
        bsonType: 'string',
        'enum': [
          'Natural',
          'Juridico'
        ]
      },
      nombre: {
        bsonType: 'string'
      },
      apellido: {
        bsonType: 'string'
      },
      numero_identificacion: {
        bsonType: 'string'
      },
      tipo_identificacion: {
        bsonType: 'string'
      },
      login: {
        bsonType: 'string'
      },
      clave: {
        bsonType: 'string'
      },
      nacionalidad: {
        bsonType: 'string'
      },
      direccion: {
        bsonType: 'string'
      },
      correo: {
        bsonType: 'string'
      },
      celular: {
        bsonType: 'string'
      },
      ciudad: {
        bsonType: 'string'
      },
      departamento: {
        bsonType: 'string'
      },
      codigo_postal: {
        bsonType: 'string'
      },
      cuenta: {
        bsonType: [
          'array',
          'null'
        ],
        items: {
          bsonType: 'string'
        }
      }
    }
  }
}

//Cuenta
{
  $jsonSchema: {
    bsonType: 'object',
    required: [
      'tipo',
      'estado',
      'numeroCuenta',
      'saldo',
      'fecha_ultima_transaccion',
      'fecha_creacion',
      'operaciones_cuenta'
    ],
    properties: {
      tipo: {
        bsonType: 'string',
        'enum': [
          'Ahorros',
          'Corriente',
          'AFC'
        ]
      },
      estado: {
        bsonType: 'string',
        'enum': [
          'Activa',
          'Cerrada',
          'Desactivada'
        ]
      },
      numeroCuenta: {
        bsonType: 'string'
      },
      saldo: {
        bsonType: 'int'
      },
      fecha_ultima_transaccion: {
        bsonType: 'date'
      },
      fecha_creaccion: {
        bsonType: 'date'
      },
      operaciones_cuenta: {
        bsonType: [
          'array',
          'null'
        ],
        items: {
          bsonType: 'object',
          required: [
            '_id',
            'tipo',
            'cuenta_afectada',
            'valor',
            'fecha',
            'punto_atencion'
          ],
          properties: {
            _id: {
              bsonType: 'int'
            },
            tipo: {
              bsonType: 'string',
              'enum': [
                'abrirCuenta',
                'cerrarCuenta',
                'consignar',
                'retirar',
                'transferir'
              ]
            },
            cuenta_afectada: {
              bsonType: 'string'
            },
            fecha: {
              bsonType: 'date'
            },
            valor: {
              bsonType: 'int'
            },
            punto_atencion: {
              bsonType: [
                'array',
                'null'
              ],
              items: {
                bsonType: 'object',
                required: [
                  'tipo',
                  'operaciones_validas',
                  'oficina'
                ],
                properties: {
                  tipo: {
                    bsonType: 'string',
                    'enum': [
                      'personalizada',
                      'cajeroAutomatico',
                      'digital'
                    ]
                  },
                  operaciones_validas: {
                    bsonType: 'array',
                    items: {
                      bsonType: 'string',
                      'enum': [
                        'abrirCuenta',
                        'cerrarCuenta',
                        'consignar',
                        'retirar',
                        'transferir'
                      ]
                    }
                  },
                  oficina: {
                    bsonType: [
                      'int',
                      'null'
                    ]
                  }
                }
              }
            }
          }
        }
      }
    }
  }
}

//Empleado
{
    $jsonSchema: {
      bsonType: 'object',
      required: [
        'rol',
        'nombre',
        'apellido',
        'numero_identificacion',
        'tipo_identificacion',
        'login',
        'clave',
        'nacionalidad',
        'direccion',
        'correo',
        'celular',
        'ciudad',
        'departamento',
        'codigo_postal'
      ],
      properties: {
        rol: {
          bsonType: 'string',
          'enum': [
            'GerenteGeneral',
            'GerenteOficina',
            'Cajero'
          ]
        },
        nombre: {
          bsonType: 'string'
        },
        apellido: {
          bsonType: 'string'
        },
        numero_identificacion: {
          bsonType: 'string'
        },
        tipo_identificacion: {
          bsonType: 'string'
        },
        login: {
          bsonType: 'string'
        },
        clave: {
          bsonType: 'string'
        },
        nacionalidad: {
          bsonType: 'string'
        },
        direccion: {
          bsonType: 'string'
        },
        correo: {
          bsonType: 'string'
        },
        celular: {
          bsonType: 'string'
        },
        ciudad: {
          bsonType: 'string'
        },
        departamento: {
          bsonType: 'string'
        },
        codigo_postal: {
          bsonType: 'string'
        }
      }
    }
  }

  //LogOperacion
  {
    $jsonSchema: {
      bsonType: 'object',
      required: [
        'id'
      ],
      properties: {
        id: {
          bsonType: [
            'array',
            'null'
          ],
          items: {
            bsonType: 'int'
          }
        }
      }
    }
  }

  //Oficina
  {
    $jsonSchema: {
      bsonType: 'object',
      required: [
        '_id',
        'nombre',
        'direccion',
        'numero_puntos_atencion',
        'empleados'
      ],
      properties: {
        _id: {
          bsonType: 'int'
        },
        nombre: {
          bsonType: 'string'
        },
        direccion: {
          bsonType: 'string'
        },
        numero_puntos_atencion: {
          bsonType: 'int'
        },
        empleados: {
          bsonType: 'array',
          items: {
            bsonType: 'string'
          }
        }
      }
    }
  }