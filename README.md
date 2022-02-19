# giftscheduler

The secret Santa app with constraint management

The GiftScheduler is an application scheduling gift distribution within a group.

A scheduling plan respects the following properties:

    - Each member of a group receives one and only one gift
    - Each member of a group offers one and only one gift
    - A member can not offer a gift to a member if he belongs to his exclusion list
    - A member can not receive a gift from a member belonging to his exclusion list

Inputs:

    - A list of members (name + address) 
    - A list of exclusions (giver/receiver)
    - Credentials to send invitations
    - A group name (Optional)

Outputs:

    - A scheduling plan respecting the list of exclusions
    - Messages to members with their gift assignments 
