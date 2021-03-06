PGDMP     3    6            
    x            obligatorio #   12.4 (Ubuntu 12.4-0ubuntu0.20.04.1)    12.3 @    (           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            )           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            *           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            +           1262    49712    obligatorio    DATABASE     }   CREATE DATABASE obligatorio WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'es_UY.UTF-8' LC_CTYPE = 'es_UY.UTF-8';
    DROP DATABASE obligatorio;
                postgres    false            ?            1259    49713 
   aplicacion    TABLE     ?   CREATE TABLE public.aplicacion (
    id_aplicacion character varying(15) NOT NULL,
    nombre_aplicacion character varying(25)
);
    DROP TABLE public.aplicacion;
       public         heap    postgres    false            ,           0    0    TABLE aplicacion    ACL     D   GRANT SELECT,INSERT,UPDATE ON TABLE public.aplicacion TO rol_admin;
          public          postgres    false    202            ?            1259    49716    estados    TABLE     v   CREATE TABLE public.estados (
    cod_estado character varying(10) NOT NULL,
    desc_estado character varying(50)
);
    DROP TABLE public.estados;
       public         heap    postgres    false            ?            1259    49719    funcionalidad    TABLE     ?   CREATE TABLE public.funcionalidad (
    nombre_funcionalidad character varying(15) NOT NULL,
    id_aplicacion character varying(15) NOT NULL,
    descripcion character varying(30)
);
 !   DROP TABLE public.funcionalidad;
       public         heap    postgres    false            -           0    0    TABLE funcionalidad    ACL     ?   GRANT SELECT,INSERT,UPDATE ON TABLE public.funcionalidad TO rol_admin;
GRANT SELECT,INSERT,UPDATE ON TABLE public.funcionalidad TO rol_admin_app;
          public          postgres    false    204            ?            1259    49722    menu    TABLE     ?   CREATE TABLE public.menu (
    id_menu character varying(15) NOT NULL,
    id_aplicacion character varying(15) NOT NULL,
    nombre_menu character varying(15)
);
    DROP TABLE public.menu;
       public         heap    postgres    false            .           0    0 
   TABLE menu    ACL     y   GRANT SELECT,INSERT,UPDATE ON TABLE public.menu TO rol_admin;
GRANT SELECT,INSERT ON TABLE public.menu TO rol_admin_app;
          public          postgres    false    205            ?            1259    49725    menu_funcionalidad    TABLE     ?   CREATE TABLE public.menu_funcionalidad (
    id_menu character varying(15) NOT NULL,
    id_aplicacion character varying(15) NOT NULL,
    nombre_funcionalidad character varying(15) NOT NULL
);
 &   DROP TABLE public.menu_funcionalidad;
       public         heap    postgres    false            /           0    0    TABLE menu_funcionalidad    ACL     ?   GRANT SELECT,INSERT,UPDATE ON TABLE public.menu_funcionalidad TO rol_admin;
GRANT SELECT,INSERT ON TABLE public.menu_funcionalidad TO rol_admin_app;
          public          postgres    false    206            ?            1259    49728    persona    TABLE     ?   CREATE TABLE public.persona (
    ci character varying(14) NOT NULL,
    nombre character varying(15) NOT NULL,
    apellido character varying(15) NOT NULL,
    fecha_nacimiento date,
    sexo character varying(10),
    telefono character varying(15)
);
    DROP TABLE public.persona;
       public         heap    postgres    false            0           0    0    TABLE persona    ACL        GRANT SELECT,INSERT,UPDATE ON TABLE public.persona TO rol_admin;
GRANT SELECT,INSERT ON TABLE public.persona TO rol_admin_app;
          public          postgres    false    207            ?            1259    49731    rol    TABLE     y   CREATE TABLE public.rol (
    id_rol character varying(15) NOT NULL,
    id_aplicacion character varying(15) NOT NULL
);
    DROP TABLE public.rol;
       public         heap    postgres    false            1           0    0 	   TABLE rol    ACL     ~   GRANT SELECT,INSERT,UPDATE ON TABLE public.rol TO rol_admin;
GRANT SELECT,INSERT,UPDATE ON TABLE public.rol TO rol_admin_app;
          public          postgres    false    208            ?            1259    49734    rol_funcionalidad    TABLE     ?   CREATE TABLE public.rol_funcionalidad (
    id_rol character varying(15) NOT NULL,
    id_aplicacion character varying(15) NOT NULL,
    nombre_funcionalidad character varying(15) NOT NULL
);
 %   DROP TABLE public.rol_funcionalidad;
       public         heap    postgres    false            2           0    0    TABLE rol_funcionalidad    ACL     ?   GRANT SELECT,INSERT,UPDATE ON TABLE public.rol_funcionalidad TO rol_admin;
GRANT SELECT,INSERT,UPDATE ON TABLE public.rol_funcionalidad TO rol_admin_app;
          public          postgres    false    209            ?            1259    49737    tipo_evento    TABLE     y   CREATE TABLE public.tipo_evento (
    id_evento character varying(10) NOT NULL,
    desc_evento character varying(50)
);
    DROP TABLE public.tipo_evento;
       public         heap    postgres    false            ?            1259    49740    usuario    TABLE     ?   CREATE TABLE public.usuario (
    nombre_usuario character varying(15) NOT NULL,
    ci character varying(14) NOT NULL,
    cod_estado character varying(10) NOT NULL
);
    DROP TABLE public.usuario;
       public         heap    postgres    false            3           0    0    TABLE usuario    ACL     ?   GRANT SELECT,INSERT,UPDATE ON TABLE public.usuario TO rol_admin;
GRANT SELECT,INSERT,UPDATE ON TABLE public.usuario TO rol_admin_app;
          public          postgres    false    211            ?            1259    49743    usuario_bitacora    TABLE     ?   CREATE TABLE public.usuario_bitacora (
    usuario_modificador character varying NOT NULL,
    id_evento character varying NOT NULL,
    fecha timestamp without time zone NOT NULL,
    nombre_usuario character varying NOT NULL
);
 $   DROP TABLE public.usuario_bitacora;
       public         heap    postgres    false            4           0    0    TABLE usuario_bitacora    ACL     ?   GRANT SELECT,INSERT ON TABLE public.usuario_bitacora TO rol_admin;
GRANT INSERT ON TABLE public.usuario_bitacora TO rol_admin_app;
          public          postgres    false    212            ?            1259    49749    usuario_rol    TABLE     ?   CREATE TABLE public.usuario_rol (
    id_rol character varying(15) NOT NULL,
    id_aplicacion character varying(15) NOT NULL,
    nombre_usuario character varying(15) NOT NULL,
    cod_estado character varying(15) NOT NULL
);
    DROP TABLE public.usuario_rol;
       public         heap    postgres    false            5           0    0    TABLE usuario_rol    ACL     ?   GRANT SELECT,INSERT,UPDATE ON TABLE public.usuario_rol TO rol_admin;
GRANT SELECT,INSERT,UPDATE ON TABLE public.usuario_rol TO rol_admin_app;
          public          postgres    false    213            ?            1259    49752    usuario_rol_bitacora    TABLE     ?  CREATE TABLE public.usuario_rol_bitacora (
    id_evento character varying NOT NULL,
    fecha timestamp without time zone NOT NULL,
    usuario_modificador character varying NOT NULL,
    id_rol character varying NOT NULL,
    id_aplicacion character varying NOT NULL,
    nombre_usuario character varying NOT NULL
);
 (   DROP TABLE public.usuario_rol_bitacora;
       public         heap    postgres    false            6           0    0    TABLE usuario_rol_bitacora    ACL     ?   GRANT SELECT,INSERT ON TABLE public.usuario_rol_bitacora TO rol_admin;
GRANT INSERT ON TABLE public.usuario_rol_bitacora TO rol_admin_app;
          public          postgres    false    214            ?            1259    49758    vista_admin_apps    VIEW     y  CREATE VIEW public.vista_admin_apps AS
 SELECT ur.id_aplicacion,
    app.nombre_aplicacion,
    ur.nombre_usuario
   FROM (public.usuario_rol ur
     JOIN public.aplicacion app ON (((ur.id_aplicacion)::text = (app.id_aplicacion)::text)))
  WHERE (((ur.nombre_usuario)::text = CURRENT_USER) AND ((ur.id_rol)::text = 'adminApp'::text) AND ((ur.cod_estado)::text = 'APR'::text));
 #   DROP VIEW public.vista_admin_apps;
       public          postgres    false    213    202    213    213    213    202            7           0    0    TABLE vista_admin_apps    ACL     ?   GRANT SELECT ON TABLE public.vista_admin_apps TO rol_admin_app;
GRANT SELECT ON TABLE public.vista_admin_apps TO rol_admin;
GRANT SELECT ON TABLE public.vista_admin_apps TO rol_usuario;
          public          postgres    false    215            ?            1259    49762    vista_menu_func    VIEW     ?  CREATE VIEW public.vista_menu_func AS
 SELECT r.nombre_funcionalidad,
    men.nombre_menu,
    r.id_aplicacion
   FROM (((public.usuario_rol ur
     JOIN public.rol_funcionalidad r ON ((((ur.id_aplicacion)::text = (r.id_aplicacion)::text) AND ((r.id_rol)::text = (ur.id_rol)::text))))
     LEFT JOIN public.menu_funcionalidad mf ON ((((mf.nombre_funcionalidad)::text = (r.nombre_funcionalidad)::text) AND ((mf.id_aplicacion)::text = (r.id_aplicacion)::text))))
     LEFT JOIN public.menu men ON ((((mf.id_aplicacion)::text = (men.id_aplicacion)::text) AND ((mf.id_menu)::text = (men.id_menu)::text))))
  WHERE ((ur.nombre_usuario)::text = CURRENT_USER)
  GROUP BY r.nombre_funcionalidad, men.nombre_menu, r.id_aplicacion;
 "   DROP VIEW public.vista_menu_func;
       public          postgres    false    213    213    213    209    209    209    206    206    206    205    205    205            8           0    0    TABLE vista_menu_func    ACL     =   GRANT SELECT ON TABLE public.vista_menu_func TO rol_usuario;
          public          postgres    false    216            ?            1259    49820    vista_usuario    VIEW     ?   CREATE VIEW public.vista_usuario AS
 SELECT usuario.nombre_usuario,
    usuario.ci,
    usuario.cod_estado
   FROM public.usuario
  WHERE ((usuario.nombre_usuario)::text = CURRENT_USER);
     DROP VIEW public.vista_usuario;
       public          postgres    false    211    211    211            9           0    0    TABLE vista_usuario    ACL     x   GRANT SELECT ON TABLE public.vista_usuario TO rol_usuario;
GRANT SELECT ON TABLE public.vista_usuario TO rol_admin_app;
          public          postgres    false    218            ?            1259    49824    vista_usuarios_pendientes    VIEW     u  CREATE VIEW public.vista_usuarios_pendientes AS
 SELECT usr.nombre_usuario,
    usr.ci,
    usr.cod_estado
   FROM ((( SELECT usuario_bitacora.nombre_usuario,
            max(usuario_bitacora.fecha) AS mf
           FROM public.usuario_bitacora
          GROUP BY usuario_bitacora.nombre_usuario) u
     JOIN public.usuario_bitacora ub ON ((((u.nombre_usuario)::text = (ub.nombre_usuario)::text) AND (ub.fecha = u.mf))))
     JOIN public.usuario usr ON (((usr.nombre_usuario)::text = (u.nombre_usuario)::text)))
  WHERE ((NOT ((ub.usuario_modificador)::text = (CURRENT_USER)::text)) AND ((usr.cod_estado)::text = 'PEND'::text));
 ,   DROP VIEW public.vista_usuarios_pendientes;
       public          postgres    false    212    211    211    211    212    212            :           0    0    TABLE vista_usuarios_pendientes    ACL     ?   GRANT SELECT ON TABLE public.vista_usuarios_pendientes TO rol_admin;
GRANT SELECT ON TABLE public.vista_usuarios_pendientes TO rol_usuario;
GRANT SELECT ON TABLE public.vista_usuarios_pendientes TO rol_admin_app;
          public          postgres    false    219            ?            1259    49776    vista_usuarios_roles_pendientes    VIEW     ?  CREATE VIEW public.vista_usuarios_roles_pendientes AS
 SELECT usr_rol.id_rol,
    usr_rol.id_aplicacion,
    usr_rol.nombre_usuario,
    usr_rol.cod_estado
   FROM (((( SELECT usuario_rol_bitacora.nombre_usuario,
            usuario_rol_bitacora.id_aplicacion,
            usuario_rol_bitacora.id_rol,
            max(usuario_rol_bitacora.fecha) AS mf
           FROM public.usuario_rol_bitacora
          GROUP BY usuario_rol_bitacora.nombre_usuario, usuario_rol_bitacora.id_aplicacion, usuario_rol_bitacora.id_rol) u
     JOIN public.usuario_rol_bitacora ub ON ((((u.nombre_usuario)::text = (ub.nombre_usuario)::text) AND (ub.fecha = u.mf) AND ((ub.id_aplicacion)::text = (u.id_aplicacion)::text))))
     JOIN public.usuario_rol usr_rol ON ((((usr_rol.nombre_usuario)::text = (u.nombre_usuario)::text) AND ((usr_rol.id_aplicacion)::text = (u.id_aplicacion)::text) AND ((usr_rol.id_rol)::text = (u.id_rol)::text))))
     JOIN public.vista_admin_apps adps ON (((usr_rol.id_aplicacion)::text = (adps.id_aplicacion)::text)))
  WHERE ((NOT ((ub.usuario_modificador)::text = (CURRENT_USER)::text)) AND ((usr_rol.cod_estado)::text = ANY (ARRAY['PEND'::text, 'SUSP'::text])) AND (NOT ((u.nombre_usuario)::text = CURRENT_USER)));
 2   DROP VIEW public.vista_usuarios_roles_pendientes;
       public          postgres    false    214    215    214    214    214    214    213    213    213    213            ;           0    0 %   TABLE vista_usuarios_roles_pendientes    ACL     ?   GRANT SELECT ON TABLE public.vista_usuarios_roles_pendientes TO rol_admin;
GRANT SELECT ON TABLE public.vista_usuarios_roles_pendientes TO rol_admin_app;
          public          postgres    false    217                      0    49713 
   aplicacion 
   TABLE DATA           F   COPY public.aplicacion (id_aplicacion, nombre_aplicacion) FROM stdin;
    public          postgres    false    202   kU                 0    49716    estados 
   TABLE DATA           :   COPY public.estados (cod_estado, desc_estado) FROM stdin;
    public          postgres    false    203   ?U                 0    49719    funcionalidad 
   TABLE DATA           Y   COPY public.funcionalidad (nombre_funcionalidad, id_aplicacion, descripcion) FROM stdin;
    public          postgres    false    204   ?U                 0    49722    menu 
   TABLE DATA           C   COPY public.menu (id_menu, id_aplicacion, nombre_menu) FROM stdin;
    public          postgres    false    205   0V                 0    49725    menu_funcionalidad 
   TABLE DATA           Z   COPY public.menu_funcionalidad (id_menu, id_aplicacion, nombre_funcionalidad) FROM stdin;
    public          postgres    false    206   ?V                 0    49728    persona 
   TABLE DATA           Y   COPY public.persona (ci, nombre, apellido, fecha_nacimiento, sexo, telefono) FROM stdin;
    public          postgres    false    207   ?V                 0    49731    rol 
   TABLE DATA           4   COPY public.rol (id_rol, id_aplicacion) FROM stdin;
    public          postgres    false    208   ?W                  0    49734    rol_funcionalidad 
   TABLE DATA           X   COPY public.rol_funcionalidad (id_rol, id_aplicacion, nombre_funcionalidad) FROM stdin;
    public          postgres    false    209    X       !          0    49737    tipo_evento 
   TABLE DATA           =   COPY public.tipo_evento (id_evento, desc_evento) FROM stdin;
    public          postgres    false    210   BX       "          0    49740    usuario 
   TABLE DATA           A   COPY public.usuario (nombre_usuario, ci, cod_estado) FROM stdin;
    public          postgres    false    211   _X       #          0    49743    usuario_bitacora 
   TABLE DATA           a   COPY public.usuario_bitacora (usuario_modificador, id_evento, fecha, nombre_usuario) FROM stdin;
    public          postgres    false    212   ?X       $          0    49749    usuario_rol 
   TABLE DATA           X   COPY public.usuario_rol (id_rol, id_aplicacion, nombre_usuario, cod_estado) FROM stdin;
    public          postgres    false    213   |Z       %          0    49752    usuario_rol_bitacora 
   TABLE DATA           |   COPY public.usuario_rol_bitacora (id_evento, fecha, usuario_modificador, id_rol, id_aplicacion, nombre_usuario) FROM stdin;
    public          postgres    false    214   5[       }           2606    49782    aplicacion Aplicacion_pkey 
   CONSTRAINT     e   ALTER TABLE ONLY public.aplicacion
    ADD CONSTRAINT "Aplicacion_pkey" PRIMARY KEY (id_aplicacion);
 F   ALTER TABLE ONLY public.aplicacion DROP CONSTRAINT "Aplicacion_pkey";
       public            postgres    false    202                       2606    49784    estados Estados_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.estados
    ADD CONSTRAINT "Estados_pkey" PRIMARY KEY (cod_estado);
 @   ALTER TABLE ONLY public.estados DROP CONSTRAINT "Estados_pkey";
       public            postgres    false    203            ?           2606    49786     funcionalidad Funcionalidad_pkey 
   CONSTRAINT     ?   ALTER TABLE ONLY public.funcionalidad
    ADD CONSTRAINT "Funcionalidad_pkey" PRIMARY KEY (nombre_funcionalidad, id_aplicacion);
 L   ALTER TABLE ONLY public.funcionalidad DROP CONSTRAINT "Funcionalidad_pkey";
       public            postgres    false    204    204            ?           2606    49788    menu Menu_pkey 
   CONSTRAINT     b   ALTER TABLE ONLY public.menu
    ADD CONSTRAINT "Menu_pkey" PRIMARY KEY (id_menu, id_aplicacion);
 :   ALTER TABLE ONLY public.menu DROP CONSTRAINT "Menu_pkey";
       public            postgres    false    205    205            ?           2606    49790    persona Persona_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.persona
    ADD CONSTRAINT "Persona_pkey" PRIMARY KEY (ci);
 @   ALTER TABLE ONLY public.persona DROP CONSTRAINT "Persona_pkey";
       public            postgres    false    207            ?           2606    49792    rol Rol_pkey 
   CONSTRAINT     _   ALTER TABLE ONLY public.rol
    ADD CONSTRAINT "Rol_pkey" PRIMARY KEY (id_rol, id_aplicacion);
 8   ALTER TABLE ONLY public.rol DROP CONSTRAINT "Rol_pkey";
       public            postgres    false    208    208            ?           2606    49794    tipo_evento Tipo_evento_pkey 
   CONSTRAINT     c   ALTER TABLE ONLY public.tipo_evento
    ADD CONSTRAINT "Tipo_evento_pkey" PRIMARY KEY (id_evento);
 H   ALTER TABLE ONLY public.tipo_evento DROP CONSTRAINT "Tipo_evento_pkey";
       public            postgres    false    210            ?           2606    49796    usuario Usuario_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT "Usuario_pkey" PRIMARY KEY (nombre_usuario);
 @   ALTER TABLE ONLY public.usuario DROP CONSTRAINT "Usuario_pkey";
       public            postgres    false    211            ?           2606    49798 *   menu_funcionalidad menu_funcionalidad_pkey 
   CONSTRAINT     ?   ALTER TABLE ONLY public.menu_funcionalidad
    ADD CONSTRAINT menu_funcionalidad_pkey PRIMARY KEY (id_menu, id_aplicacion, nombre_funcionalidad);
 T   ALTER TABLE ONLY public.menu_funcionalidad DROP CONSTRAINT menu_funcionalidad_pkey;
       public            postgres    false    206    206    206            ?           2606    49800 (   rol_funcionalidad rol_funcionalidad_pkey 
   CONSTRAINT     ?   ALTER TABLE ONLY public.rol_funcionalidad
    ADD CONSTRAINT rol_funcionalidad_pkey PRIMARY KEY (id_rol, id_aplicacion, nombre_funcionalidad);
 R   ALTER TABLE ONLY public.rol_funcionalidad DROP CONSTRAINT rol_funcionalidad_pkey;
       public            postgres    false    209    209    209            ?           2606    49802 &   usuario_bitacora usuario_bitacora_pkey 
   CONSTRAINT     ?   ALTER TABLE ONLY public.usuario_bitacora
    ADD CONSTRAINT usuario_bitacora_pkey PRIMARY KEY (usuario_modificador, id_evento, fecha, nombre_usuario);
 P   ALTER TABLE ONLY public.usuario_bitacora DROP CONSTRAINT usuario_bitacora_pkey;
       public            postgres    false    212    212    212    212            ?           2606    49804 .   usuario_rol_bitacora usuario_rol_bitacora_pkey 
   CONSTRAINT     ?   ALTER TABLE ONLY public.usuario_rol_bitacora
    ADD CONSTRAINT usuario_rol_bitacora_pkey PRIMARY KEY (id_evento, fecha, usuario_modificador, id_rol, id_aplicacion, nombre_usuario);
 X   ALTER TABLE ONLY public.usuario_rol_bitacora DROP CONSTRAINT usuario_rol_bitacora_pkey;
       public            postgres    false    214    214    214    214    214    214            ?           2606    49806    usuario_rol usuario_rol_pkey 
   CONSTRAINT     }   ALTER TABLE ONLY public.usuario_rol
    ADD CONSTRAINT usuario_rol_pkey PRIMARY KEY (id_rol, id_aplicacion, nombre_usuario);
 F   ALTER TABLE ONLY public.usuario_rol DROP CONSTRAINT usuario_rol_pkey;
       public            postgres    false    213    213    213               K   x?3??*M?s,(?2?HM)?1?9??9?9
?,9-?,-9?͹L`?JsC '???N????? ?i?            x?????? ? ?         =   x?Ʊ?0??&??d?4lWn?o???<;?a1?x????7??dʱT???$/'t?         E   x?3?4?L?2?????I\e`?H??&%??ӘDq? ?$?̀ ?Q\?N?@???W? ?         <   x?+?4?L+?3?2?41??a?ps?(.3  ?aL????3?i\1z\\\ 7?         ?   x?m??
?0??ɻL?4]?? >?? =8t?a??tvcC?'$?i?4???? G?i?q?Eo??>???1u??c?A???lv?e?؎=????????D}?(R??%?3??.(*`Uu59??PΨ????;U?8
m?#-<%" %?a]T???aQ?         p   x?M?;
?0Dk?0?$??+K?-?H??k??????}5ywM[????ؽ+4??kR՟URNZ%m2?\dS??0?XX???0,!*????a?]??????^ ??<          2   x?KL???s,(?4?L+?3?26????s?J?`?D?BcNC?????? N??      !      x?????? ? ?      "   }   x?M?A?0???QX$??`??!;{	?Di??_???\^???????c6?? f?H??/????7>?*7?E??V"?c??9?ʛ?"^]????J~"X5;	?1"?????|tVpn?1?K6?      #   ?  x????N?@?????????ώR?PDQW?XJ?P????I
E??ek?????sg??x??c???u???Dk?+?BV,B?????[??k?76??????~?9<??}?p???????? "?̆v!??k1VL?CN2??V0AvD???%i?'?d?3?????s????RD!S????u??2͚E?d?vb???D???"	0??S??sA?/d??~????I?J[?,???til??[?f???ƂH?F????D0,?@hf??????#}??GkӚ?(??f?m.??0j?q	???sg	Ū???AH??'?e_T??e???z?????-a??(?S"W??E,Z?s?%X@%R?????]???/R??NIT?????u?;J%?      $   ?   x?u??? ?gx?QXLc??r?????????ʍ?0??s ??1	?'?LD?W
?5???[yY?Yǈ??m??C??? ???4?z??????<33??????Vƶ5?ɪ?,?撸??b?(????S???^]$ǓT=??pp?ͱ_7!@???m????E?      %     x????n?@@??+????v?x??JQ?Yuc)?j???{mC??c??HXȇs?ss?????5?5?+?,1KpA??W??4OK???l?\?}???rftC??<v????"^d???????h~?>???J??wh?\b??^H?G??<?f?$ 2?~?U???8?#&?|]??3?"n&|2?SQe???	1C?Ȏcd?;?;l7%?!h??K"?o{?1E????!????ח????0JNP?s2????r@)d?%1?Q6ª?.P??b??{QX?t??k?&?j??(???E)??2?,????+???? ?bGY?:?Bv6oH?????=l?/c?ퟔf?P?Y??@??{m?Q)??P?5?tRI??T?J??{??.?&??#[??0h7?l|l???@<I?S<?Wœ5?(??ڮ??djƶ??{??Mu???v????
2??yQ?ݴ????V@?^v?.??=?c???????c{?9N???>?AZӜ?????y??v?g??Q???΁E?u????f?:?}     