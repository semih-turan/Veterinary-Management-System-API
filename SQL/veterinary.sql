PGDMP           
            |         
   veterinary    16.2    16.2 L    X           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            Y           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            Z           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            [           1262    32596 
   veterinary    DATABASE     l   CREATE DATABASE veterinary WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'C';
    DROP DATABASE veterinary;
                postgres    false            �            1259    33488    animals    TABLE     V  CREATE TABLE public.animals (
    animal_date_of_birth date,
    animal_customer_id integer NOT NULL,
    animal_id bigint NOT NULL,
    animal_breed character varying(255),
    animal_color character varying(255),
    animal_gender character varying(255),
    animal_name character varying(255),
    animal_species character varying(255)
);
    DROP TABLE public.animals;
       public         heap    postgres    false            �            1259    33486    animals_animal_customer_id_seq    SEQUENCE     �   CREATE SEQUENCE public.animals_animal_customer_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 5   DROP SEQUENCE public.animals_animal_customer_id_seq;
       public          postgres    false    217            \           0    0    animals_animal_customer_id_seq    SEQUENCE OWNED BY     a   ALTER SEQUENCE public.animals_animal_customer_id_seq OWNED BY public.animals.animal_customer_id;
          public          postgres    false    215            �            1259    33487    animals_animal_id_seq    SEQUENCE     ~   CREATE SEQUENCE public.animals_animal_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.animals_animal_id_seq;
       public          postgres    false    217            ]           0    0    animals_animal_id_seq    SEQUENCE OWNED BY     O   ALTER SEQUENCE public.animals_animal_id_seq OWNED BY public.animals.animal_id;
          public          postgres    false    216            �            1259    33500    appointments    TABLE        CREATE TABLE public.appointments (
    appointment_animal_id integer NOT NULL,
    appointment_available_date_id bigint,
    appointment_date timestamp(6) without time zone,
    appointment_doctor_id integer NOT NULL,
    appointment_id bigint NOT NULL
);
     DROP TABLE public.appointments;
       public         heap    postgres    false            �            1259    33497 &   appointments_appointment_animal_id_seq    SEQUENCE     �   CREATE SEQUENCE public.appointments_appointment_animal_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 =   DROP SEQUENCE public.appointments_appointment_animal_id_seq;
       public          postgres    false    221            ^           0    0 &   appointments_appointment_animal_id_seq    SEQUENCE OWNED BY     q   ALTER SEQUENCE public.appointments_appointment_animal_id_seq OWNED BY public.appointments.appointment_animal_id;
          public          postgres    false    218            �            1259    33498 &   appointments_appointment_doctor_id_seq    SEQUENCE     �   CREATE SEQUENCE public.appointments_appointment_doctor_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 =   DROP SEQUENCE public.appointments_appointment_doctor_id_seq;
       public          postgres    false    221            _           0    0 &   appointments_appointment_doctor_id_seq    SEQUENCE OWNED BY     q   ALTER SEQUENCE public.appointments_appointment_doctor_id_seq OWNED BY public.appointments.appointment_doctor_id;
          public          postgres    false    219            �            1259    33499    appointments_appointment_id_seq    SEQUENCE     �   CREATE SEQUENCE public.appointments_appointment_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 6   DROP SEQUENCE public.appointments_appointment_id_seq;
       public          postgres    false    221            `           0    0    appointments_appointment_id_seq    SEQUENCE OWNED BY     c   ALTER SEQUENCE public.appointments_appointment_id_seq OWNED BY public.appointments.appointment_id;
          public          postgres    false    220            �            1259    33510    available_date    TABLE     �   CREATE TABLE public.available_date (
    available_date date,
    available_date_doctor_id integer NOT NULL,
    available_date_id bigint NOT NULL
);
 "   DROP TABLE public.available_date;
       public         heap    postgres    false            �            1259    33508 +   available_date_available_date_doctor_id_seq    SEQUENCE     �   CREATE SEQUENCE public.available_date_available_date_doctor_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 B   DROP SEQUENCE public.available_date_available_date_doctor_id_seq;
       public          postgres    false    224            a           0    0 +   available_date_available_date_doctor_id_seq    SEQUENCE OWNED BY     {   ALTER SEQUENCE public.available_date_available_date_doctor_id_seq OWNED BY public.available_date.available_date_doctor_id;
          public          postgres    false    222            �            1259    33509 $   available_date_available_date_id_seq    SEQUENCE     �   CREATE SEQUENCE public.available_date_available_date_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ;   DROP SEQUENCE public.available_date_available_date_id_seq;
       public          postgres    false    224            b           0    0 $   available_date_available_date_id_seq    SEQUENCE OWNED BY     m   ALTER SEQUENCE public.available_date_available_date_id_seq OWNED BY public.available_date.available_date_id;
          public          postgres    false    223            �            1259    33518 	   customers    TABLE       CREATE TABLE public.customers (
    customer_id bigint NOT NULL,
    customer_address character varying(255),
    customer_city character varying(255),
    customer_email character varying(255),
    customer_name character varying(255),
    customer_phone character varying(255)
);
    DROP TABLE public.customers;
       public         heap    postgres    false            �            1259    33517    customers_customer_id_seq    SEQUENCE     �   CREATE SEQUENCE public.customers_customer_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 0   DROP SEQUENCE public.customers_customer_id_seq;
       public          postgres    false    226            c           0    0    customers_customer_id_seq    SEQUENCE OWNED BY     W   ALTER SEQUENCE public.customers_customer_id_seq OWNED BY public.customers.customer_id;
          public          postgres    false    225            �            1259    33531    doctors    TABLE       CREATE TABLE public.doctors (
    doctor_id bigint NOT NULL,
    doctor_address character varying(255),
    doctor_city character varying(255),
    doctor_email character varying(255),
    doctor_name character varying(255),
    doctor_phone character varying(255)
);
    DROP TABLE public.doctors;
       public         heap    postgres    false            �            1259    33530    doctors_doctor_id_seq    SEQUENCE     ~   CREATE SEQUENCE public.doctors_doctor_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.doctors_doctor_id_seq;
       public          postgres    false    228            d           0    0    doctors_doctor_id_seq    SEQUENCE OWNED BY     O   ALTER SEQUENCE public.doctors_doctor_id_seq OWNED BY public.doctors.doctor_id;
          public          postgres    false    227            �            1259    33545    vaccines    TABLE     	  CREATE TABLE public.vaccines (
    vaccine_protection_end_date date,
    vaccine_protection_start_date date,
    vaccine_animal_id integer NOT NULL,
    vaccine_id bigint NOT NULL,
    vaccine_code character varying(255),
    vaccine_name character varying(255)
);
    DROP TABLE public.vaccines;
       public         heap    postgres    false            �            1259    33543    vaccines_vaccine_animal_id_seq    SEQUENCE     �   CREATE SEQUENCE public.vaccines_vaccine_animal_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 5   DROP SEQUENCE public.vaccines_vaccine_animal_id_seq;
       public          postgres    false    231            e           0    0    vaccines_vaccine_animal_id_seq    SEQUENCE OWNED BY     a   ALTER SEQUENCE public.vaccines_vaccine_animal_id_seq OWNED BY public.vaccines.vaccine_animal_id;
          public          postgres    false    229            �            1259    33544    vaccines_vaccine_id_seq    SEQUENCE     �   CREATE SEQUENCE public.vaccines_vaccine_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE public.vaccines_vaccine_id_seq;
       public          postgres    false    231            f           0    0    vaccines_vaccine_id_seq    SEQUENCE OWNED BY     S   ALTER SEQUENCE public.vaccines_vaccine_id_seq OWNED BY public.vaccines.vaccine_id;
          public          postgres    false    230            �           2604    33491    animals animal_customer_id    DEFAULT     �   ALTER TABLE ONLY public.animals ALTER COLUMN animal_customer_id SET DEFAULT nextval('public.animals_animal_customer_id_seq'::regclass);
 I   ALTER TABLE public.animals ALTER COLUMN animal_customer_id DROP DEFAULT;
       public          postgres    false    217    215    217            �           2604    33492    animals animal_id    DEFAULT     v   ALTER TABLE ONLY public.animals ALTER COLUMN animal_id SET DEFAULT nextval('public.animals_animal_id_seq'::regclass);
 @   ALTER TABLE public.animals ALTER COLUMN animal_id DROP DEFAULT;
       public          postgres    false    217    216    217            �           2604    33503 "   appointments appointment_animal_id    DEFAULT     �   ALTER TABLE ONLY public.appointments ALTER COLUMN appointment_animal_id SET DEFAULT nextval('public.appointments_appointment_animal_id_seq'::regclass);
 Q   ALTER TABLE public.appointments ALTER COLUMN appointment_animal_id DROP DEFAULT;
       public          postgres    false    221    218    221            �           2604    33504 "   appointments appointment_doctor_id    DEFAULT     �   ALTER TABLE ONLY public.appointments ALTER COLUMN appointment_doctor_id SET DEFAULT nextval('public.appointments_appointment_doctor_id_seq'::regclass);
 Q   ALTER TABLE public.appointments ALTER COLUMN appointment_doctor_id DROP DEFAULT;
       public          postgres    false    221    219    221            �           2604    33505    appointments appointment_id    DEFAULT     �   ALTER TABLE ONLY public.appointments ALTER COLUMN appointment_id SET DEFAULT nextval('public.appointments_appointment_id_seq'::regclass);
 J   ALTER TABLE public.appointments ALTER COLUMN appointment_id DROP DEFAULT;
       public          postgres    false    220    221    221            �           2604    33513 '   available_date available_date_doctor_id    DEFAULT     �   ALTER TABLE ONLY public.available_date ALTER COLUMN available_date_doctor_id SET DEFAULT nextval('public.available_date_available_date_doctor_id_seq'::regclass);
 V   ALTER TABLE public.available_date ALTER COLUMN available_date_doctor_id DROP DEFAULT;
       public          postgres    false    224    222    224            �           2604    33514     available_date available_date_id    DEFAULT     �   ALTER TABLE ONLY public.available_date ALTER COLUMN available_date_id SET DEFAULT nextval('public.available_date_available_date_id_seq'::regclass);
 O   ALTER TABLE public.available_date ALTER COLUMN available_date_id DROP DEFAULT;
       public          postgres    false    224    223    224            �           2604    33521    customers customer_id    DEFAULT     ~   ALTER TABLE ONLY public.customers ALTER COLUMN customer_id SET DEFAULT nextval('public.customers_customer_id_seq'::regclass);
 D   ALTER TABLE public.customers ALTER COLUMN customer_id DROP DEFAULT;
       public          postgres    false    225    226    226            �           2604    33534    doctors doctor_id    DEFAULT     v   ALTER TABLE ONLY public.doctors ALTER COLUMN doctor_id SET DEFAULT nextval('public.doctors_doctor_id_seq'::regclass);
 @   ALTER TABLE public.doctors ALTER COLUMN doctor_id DROP DEFAULT;
       public          postgres    false    228    227    228            �           2604    33548    vaccines vaccine_animal_id    DEFAULT     �   ALTER TABLE ONLY public.vaccines ALTER COLUMN vaccine_animal_id SET DEFAULT nextval('public.vaccines_vaccine_animal_id_seq'::regclass);
 I   ALTER TABLE public.vaccines ALTER COLUMN vaccine_animal_id DROP DEFAULT;
       public          postgres    false    231    229    231            �           2604    33549    vaccines vaccine_id    DEFAULT     z   ALTER TABLE ONLY public.vaccines ALTER COLUMN vaccine_id SET DEFAULT nextval('public.vaccines_vaccine_id_seq'::regclass);
 B   ALTER TABLE public.vaccines ALTER COLUMN vaccine_id DROP DEFAULT;
       public          postgres    false    230    231    231            G          0    33488    animals 
   TABLE DATA           �   COPY public.animals (animal_date_of_birth, animal_customer_id, animal_id, animal_breed, animal_color, animal_gender, animal_name, animal_species) FROM stdin;
    public          postgres    false    217   l`       K          0    33500    appointments 
   TABLE DATA           �   COPY public.appointments (appointment_animal_id, appointment_available_date_id, appointment_date, appointment_doctor_id, appointment_id) FROM stdin;
    public          postgres    false    221   �a       N          0    33510    available_date 
   TABLE DATA           e   COPY public.available_date (available_date, available_date_doctor_id, available_date_id) FROM stdin;
    public          postgres    false    224   .b       P          0    33518 	   customers 
   TABLE DATA           �   COPY public.customers (customer_id, customer_address, customer_city, customer_email, customer_name, customer_phone) FROM stdin;
    public          postgres    false    226   �b       R          0    33531    doctors 
   TABLE DATA           r   COPY public.doctors (doctor_id, doctor_address, doctor_city, doctor_email, doctor_name, doctor_phone) FROM stdin;
    public          postgres    false    228   Ad       U          0    33545    vaccines 
   TABLE DATA           �   COPY public.vaccines (vaccine_protection_end_date, vaccine_protection_start_date, vaccine_animal_id, vaccine_id, vaccine_code, vaccine_name) FROM stdin;
    public          postgres    false    231   f       g           0    0    animals_animal_customer_id_seq    SEQUENCE SET     M   SELECT pg_catalog.setval('public.animals_animal_customer_id_seq', 1, false);
          public          postgres    false    215            h           0    0    animals_animal_id_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.animals_animal_id_seq', 10, true);
          public          postgres    false    216            i           0    0 &   appointments_appointment_animal_id_seq    SEQUENCE SET     U   SELECT pg_catalog.setval('public.appointments_appointment_animal_id_seq', 1, false);
          public          postgres    false    218            j           0    0 &   appointments_appointment_doctor_id_seq    SEQUENCE SET     U   SELECT pg_catalog.setval('public.appointments_appointment_doctor_id_seq', 1, false);
          public          postgres    false    219            k           0    0    appointments_appointment_id_seq    SEQUENCE SET     N   SELECT pg_catalog.setval('public.appointments_appointment_id_seq', 10, true);
          public          postgres    false    220            l           0    0 +   available_date_available_date_doctor_id_seq    SEQUENCE SET     Z   SELECT pg_catalog.setval('public.available_date_available_date_doctor_id_seq', 1, false);
          public          postgres    false    222            m           0    0 $   available_date_available_date_id_seq    SEQUENCE SET     S   SELECT pg_catalog.setval('public.available_date_available_date_id_seq', 10, true);
          public          postgres    false    223            n           0    0    customers_customer_id_seq    SEQUENCE SET     H   SELECT pg_catalog.setval('public.customers_customer_id_seq', 10, true);
          public          postgres    false    225            o           0    0    doctors_doctor_id_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.doctors_doctor_id_seq', 10, true);
          public          postgres    false    227            p           0    0    vaccines_vaccine_animal_id_seq    SEQUENCE SET     M   SELECT pg_catalog.setval('public.vaccines_vaccine_animal_id_seq', 1, false);
          public          postgres    false    229            q           0    0    vaccines_vaccine_id_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.vaccines_vaccine_id_seq', 10, true);
          public          postgres    false    230            �           2606    33496    animals animals_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY public.animals
    ADD CONSTRAINT animals_pkey PRIMARY KEY (animal_id);
 >   ALTER TABLE ONLY public.animals DROP CONSTRAINT animals_pkey;
       public            postgres    false    217            �           2606    33507    appointments appointments_pkey 
   CONSTRAINT     h   ALTER TABLE ONLY public.appointments
    ADD CONSTRAINT appointments_pkey PRIMARY KEY (appointment_id);
 H   ALTER TABLE ONLY public.appointments DROP CONSTRAINT appointments_pkey;
       public            postgres    false    221            �           2606    33516 "   available_date available_date_pkey 
   CONSTRAINT     o   ALTER TABLE ONLY public.available_date
    ADD CONSTRAINT available_date_pkey PRIMARY KEY (available_date_id);
 L   ALTER TABLE ONLY public.available_date DROP CONSTRAINT available_date_pkey;
       public            postgres    false    224            �           2606    33527 &   customers customers_customer_email_key 
   CONSTRAINT     k   ALTER TABLE ONLY public.customers
    ADD CONSTRAINT customers_customer_email_key UNIQUE (customer_email);
 P   ALTER TABLE ONLY public.customers DROP CONSTRAINT customers_customer_email_key;
       public            postgres    false    226            �           2606    33529 &   customers customers_customer_phone_key 
   CONSTRAINT     k   ALTER TABLE ONLY public.customers
    ADD CONSTRAINT customers_customer_phone_key UNIQUE (customer_phone);
 P   ALTER TABLE ONLY public.customers DROP CONSTRAINT customers_customer_phone_key;
       public            postgres    false    226            �           2606    33525    customers customers_pkey 
   CONSTRAINT     _   ALTER TABLE ONLY public.customers
    ADD CONSTRAINT customers_pkey PRIMARY KEY (customer_id);
 B   ALTER TABLE ONLY public.customers DROP CONSTRAINT customers_pkey;
       public            postgres    false    226            �           2606    33540     doctors doctors_doctor_email_key 
   CONSTRAINT     c   ALTER TABLE ONLY public.doctors
    ADD CONSTRAINT doctors_doctor_email_key UNIQUE (doctor_email);
 J   ALTER TABLE ONLY public.doctors DROP CONSTRAINT doctors_doctor_email_key;
       public            postgres    false    228            �           2606    33542     doctors doctors_doctor_phone_key 
   CONSTRAINT     c   ALTER TABLE ONLY public.doctors
    ADD CONSTRAINT doctors_doctor_phone_key UNIQUE (doctor_phone);
 J   ALTER TABLE ONLY public.doctors DROP CONSTRAINT doctors_doctor_phone_key;
       public            postgres    false    228            �           2606    33538    doctors doctors_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY public.doctors
    ADD CONSTRAINT doctors_pkey PRIMARY KEY (doctor_id);
 >   ALTER TABLE ONLY public.doctors DROP CONSTRAINT doctors_pkey;
       public            postgres    false    228            �           2606    33553    vaccines vaccines_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.vaccines
    ADD CONSTRAINT vaccines_pkey PRIMARY KEY (vaccine_id);
 @   ALTER TABLE ONLY public.vaccines DROP CONSTRAINT vaccines_pkey;
       public            postgres    false    231            �           2606    33569 '   appointments fk27d0xcbajwaeeun2doojsae4    FK CONSTRAINT     �   ALTER TABLE ONLY public.appointments
    ADD CONSTRAINT fk27d0xcbajwaeeun2doojsae4 FOREIGN KEY (appointment_doctor_id) REFERENCES public.doctors(doctor_id);
 Q   ALTER TABLE ONLY public.appointments DROP CONSTRAINT fk27d0xcbajwaeeun2doojsae4;
       public          postgres    false    228    221    3501            �           2606    33564 (   appointments fk8aap9xrqwpgumlausf5kw3jwe    FK CONSTRAINT     �   ALTER TABLE ONLY public.appointments
    ADD CONSTRAINT fk8aap9xrqwpgumlausf5kw3jwe FOREIGN KEY (appointment_available_date_id) REFERENCES public.available_date(available_date_id);
 R   ALTER TABLE ONLY public.appointments DROP CONSTRAINT fk8aap9xrqwpgumlausf5kw3jwe;
       public          postgres    false    3489    224    221            �           2606    33579 $   vaccines fkekhfjmpsduds8nnilqe9b467v    FK CONSTRAINT     �   ALTER TABLE ONLY public.vaccines
    ADD CONSTRAINT fkekhfjmpsduds8nnilqe9b467v FOREIGN KEY (vaccine_animal_id) REFERENCES public.animals(animal_id);
 N   ALTER TABLE ONLY public.vaccines DROP CONSTRAINT fkekhfjmpsduds8nnilqe9b467v;
       public          postgres    false    217    231    3485            �           2606    33554 #   animals fknjsvd8kplxqmf48ybxayrx6ru    FK CONSTRAINT     �   ALTER TABLE ONLY public.animals
    ADD CONSTRAINT fknjsvd8kplxqmf48ybxayrx6ru FOREIGN KEY (animal_customer_id) REFERENCES public.customers(customer_id);
 M   ALTER TABLE ONLY public.animals DROP CONSTRAINT fknjsvd8kplxqmf48ybxayrx6ru;
       public          postgres    false    217    3495    226            �           2606    33559 (   appointments fko4t945rb708af9ry6syof7bwt    FK CONSTRAINT     �   ALTER TABLE ONLY public.appointments
    ADD CONSTRAINT fko4t945rb708af9ry6syof7bwt FOREIGN KEY (appointment_animal_id) REFERENCES public.animals(animal_id);
 R   ALTER TABLE ONLY public.appointments DROP CONSTRAINT fko4t945rb708af9ry6syof7bwt;
       public          postgres    false    221    217    3485            �           2606    33574 *   available_date fkpaalwgfslp8gdi9ep8q8al16w    FK CONSTRAINT     �   ALTER TABLE ONLY public.available_date
    ADD CONSTRAINT fkpaalwgfslp8gdi9ep8q8al16w FOREIGN KEY (available_date_doctor_id) REFERENCES public.doctors(doctor_id);
 T   ALTER TABLE ONLY public.available_date DROP CONSTRAINT fkpaalwgfslp8gdi9ep8q8al16w;
       public          postgres    false    224    3501    228            G   9  x�U��n�0Dϛ�����pM\@E��^6d�X862I)ߍڢ瓵�3;Z��PZ�s�k����-��Xk_GZ���3�h�0�ҍ� �������A��B�ݠH�VÌ�z[����C_���&o0XC/N*�9��2`��?ef�|y�ed-NB-�Tb&!a�hŹ����.>aY>F�wk�ES��.t&#�y���[���m)d*��L�[[���W�ؔh���x&RB΅��2
7�>�Ѹ�0m�[׊�Ja�����|kO����װb��oK�E]
�XT���ۧ���|�}�EQ��g�C      K   i   x�MϹ�@Cј��Șٝ�\����t"
`�_�D�E�+����Dh�Ɇf�6Uvt۲��P�mS����:'�m6u.,[�Թ�mͦ΃c�6u�n������M�5/�      N   I   x�E˻�0��ԋI�����7����|���I����MQ�a0~�3�b�Xb��b�p����v_f� �M      P   �  x�]��n�0E�ï�0Aٖd��G�H��^����Ą"J���ʊ��p�j2��)�M�Z��h�g�;���sk�A�t�aIV��M丏�<��b)�0���;`��k^��5�C�g7��"�u�Mg�|�"%f���w\��	^�ծ�p��wfhG��?�.����b���Y���u;��`	j��7�9���c�ɲ\���S.�u��=հ%w� 4���Z��Xr9n#O�O$
���2��d�:��q�j�Ӳa4��6r����%���ں�pMe���;hȇ�d�C���]��}�$����*�MK!|^{�q�A������Vv:p�#�}�p����w.�P��A)��t�?>��*���~�y���	'I�C�LA�J��9�^\�ܴ�ҍ��c�)-������"��m*���R�ψ�      R   �  x�]��n�0�����JB��V�h���K/�`aS�Fv(��߱Ө�[4_�g�)��+����|�ër��o�t�Pq��h�����#Z��f���B]�Y�L��</X	E9��3�^\���F�Q��S68{#�F��I�f:�HS�	Tu�_�M�[*����;ćw�[�:��C�'�t6��R�
�/�}�<�S評촹�~��	c��b=yh��4�����}��g���#�v�*�IzTҋ=�V�r���S��L�H<e�y����S�+4d4�������������yQ�0fl
�|��_�Ǯ�����j
׻���ӝt� �7�$�,b&s6�*����O��k$`PF^u�hww�E��y��I�Ār6�:�opA�h���ga��ζ�$�(�������o��']�ݩi�?d����+�;����Nf�&fT�w��<s�      U     x�]�Mk�0���W�=�db�:���)�^��B5�����l�R*������;�BF\D\
&�T�Rn_@����X�l�t�n�1�Έ9D�X��䅊b��w���O'2��	���!�Λ$�X��K1�vҿ�*�~W� ����U��vF{!����������<c���C@p��Y0�T����Wߝ+�z<��-�P��>��`���h�n 9��pxM����X�ù�3��Y� ��Ur�Q��)�;�ڶԿКU+A#�������d�@����Y����C���#     