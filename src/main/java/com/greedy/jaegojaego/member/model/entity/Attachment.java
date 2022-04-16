package com.greedy.jaegojaego.member.model.entity;

import lombok.*;

import javax.naming.Name;
import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity(name = "Attachment")
@Table(name = "ATTACHMENT")
public class Attachment {

    @Id
    @Column(name = "ATTACHMENT_NO")
    private int attachmentNo;

    @Column(name = "ATTACHMENT_ORIGIN_NAME")
    private String attachmentOriginName;

    @Column(name = "ATTACHMENT_CHANGED_NAME")
    private String attachmentChangedName;

    @Column(name = "ATTACHMENT_PATH")
    private String attachmentPath;

    @Column(name = "ATTACHMENT_STATUS")
    private String attachmentStatus;

    @Column(name = "ATTACHMENT_KIND_NO")
    private int attachmentKindNo;

    @JoinColumn(name = "FRANCHISE_REPRESENTATIVE")
    @ManyToOne(cascade = CascadeType.PERSIST, optional = false)
    private int franchiseReprentativeNo;
}
