ALTER TABLE resources
    ADD CONSTRAINT fk_task
        FOREIGN KEY (task_id) REFERENCES tasks(id);
