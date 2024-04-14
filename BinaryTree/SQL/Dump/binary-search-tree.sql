-- Table: public.binary_search_tree

-- DROP TABLE IF EXISTS public.binary_search_tree;

CREATE TABLE IF NOT EXISTS public.binary_search_tree
(
    id bigint NOT NULL,
    numbers_list integer[]
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.binary_search_tree
    OWNER to postgres;